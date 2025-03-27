package ru.aston.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("java:S125")
public class MyClass {

    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

    public static void main(String[] args) {

        new MyClass().log();

    }

    private void log() {
        var value = "test";

        if (logger.isDebugEnabled()) {
            logger.debug("My Class:" + value); //запись строки в лог неважной информации
            //сначала происходит канкатенация строки
            //вызов метода debug()
            //уровень debug проверится (если установлен info то debug и trace в лог не попадет)
            //но новый объект уже создан
            //поэтому сначала проверяем а надо ли писать лог
        }

        logger.debug("My Class:{}", value); // можно использовать плейсхолдер
        //логирование в функциональном стиле
        logger.atInfo()
                .setMessage("My Class atInfo:{}")
                .addArgument(() -> value)
                .log();

        try {
            throw new IllegalStateException("Exception for log");
        } catch (Exception e) {
            logger.error("Exception log:", e);
        }
    }
}
