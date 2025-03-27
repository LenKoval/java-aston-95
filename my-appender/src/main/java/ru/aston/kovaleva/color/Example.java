package ru.aston.kovaleva.color;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("java:S106")
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        new Example().doSomething();
    }

    public void doSomething() {
        logger.trace("black message");
        logger.debug("blue message");
        logger.info("green message");
        logger.warn("yellow message");
        logger.error("red message");
    }
}
