package ru.aston.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericMethod {

    private static final Logger logger = LoggerFactory.getLogger(GenericMethod.class);

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();

        // Полный синтаксис:
        genericMethod.<Integer, String>print(1, "value");

        // Вывод типов K и V
        genericMethod.print(2, "value2");

        // Будет ли здесь ошибка?
        // genericMethod.print("3", "value3");

        // А здесь?
        // genericMethod.<Integer, String>print("4", "value4");
    }

    private <K, V> void print(K key, V val) {
        logger.info("key:{}, val:{}", key, val);
    }
}
