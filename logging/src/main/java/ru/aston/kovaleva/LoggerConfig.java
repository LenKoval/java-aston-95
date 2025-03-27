package ru.aston.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggerConfig.class);

    private long counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new LoggerConfig().loop();

    }

    private void loop() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            logger.info("INFO level:{}", counter);
            logger.error("ERROR level:{}", counter);
            counter++;
            Thread.sleep(3_000);
        }
    }
}
