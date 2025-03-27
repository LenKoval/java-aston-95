package ru.aston.kovaleva.mongo;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;

public class MyMongoAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    //базовый класс Logback, обеспечивающий основную функциональность аппендера.
    // Используется несинхронизированная версия для лучшей производительности при записи в базу данных.

    private static final String COLLECTION_NAME = "logs";
    private MongoTemplate mongoTemplate;

    @Override
    protected void append(ILoggingEvent eventObject) {
        // Получаем MongoTemplate через провайдер
        mongoTemplate = ApplicationContextProvider.getBean(MongoTemplate.class);

        if (mongoTemplate != null) {
            // Создаем документ для сохранения
            final BasicDBObject doc = new BasicDBObject();

            // Заполняем основные поля лога
            doc.append("level", eventObject.getLevel().toString());
            doc.append("logger", eventObject.getLoggerName());
            doc.append("thread", eventObject.getThreadName());
            doc.append("message", eventObject.getFormattedMessage());

            // Добавляем временную метку
            doc.append("timestamp", new Date(eventObject.getTimeStamp()));

            // Сохраняем в коллекцию
            mongoTemplate.insert(doc, COLLECTION_NAME);
        }
    }
}
