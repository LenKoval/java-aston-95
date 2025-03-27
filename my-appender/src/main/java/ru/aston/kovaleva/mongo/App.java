package ru.aston.kovaleva.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        processUser("User_01");

    }

    private static void processUser(String username) {
        // INFO уровень - для обычных операций
        logger.info("Обработка пользователя: {}", username);

        try {
            // Симуляция работы с пользователем
            Thread.sleep(100);

            // DEBUG уровень - для детальной отладки
            logger.debug("Пользователь {} успешно обработан", username);

        } catch (InterruptedException e) {
            // ERROR уровень - для ошибок
            logger.error("Ошибка при обработке пользователя", e);
        }

        // WARN уровень - для предупреждений
        logger.warn("Пользователь {} обработан с предупреждением", username);
    }
}
