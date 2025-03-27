package ru.aston.kovaleva.color;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    private static final String ANSI_RESET = "\u001b[0m";
    private static final String ANSI_BLACK = "\u001b[30m";
    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_YELLOW = "\u001b[33m";
    private static final String ANSI_BLUE = "\u001b[34m";

    private static final String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_PATTERN);

    @Override
    protected void append(ILoggingEvent eventObject) {
        String color = getColorForLevel(eventObject.getLevel());
        StackTraceElement caller = eventObject.getCallerData()[0];

        String message = String.format(
                "%s[%s] %s[%s.%s:%d] - %s[%s] - %s%s %s",
                color,
                sdf.format(new Date(eventObject.getTimeStamp())),
                color,
                caller.getClassName(),
                caller.getMethodName(),
                caller.getLineNumber(),
                color,
                eventObject.getLoggerName(),
                color,
                eventObject.getLevel(),
                eventObject.getFormattedMessage()
        );

        System.out.println(message);
    }

    private String getColorForLevel(Level level) {
        switch (level.toInt()) {
            case Level.ERROR_INT:
                return ANSI_RED;
            case Level.WARN_INT:
                return ANSI_YELLOW;
            case Level.INFO_INT:
                return ANSI_GREEN;
            case Level.DEBUG_INT:
                return ANSI_BLUE;
            case Level.TRACE_INT:
                return ANSI_BLACK;
            default:
                return ANSI_RESET;
        }
    }
}
