package ru.aston.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aston.kovaleva.entries.Animal;
import ru.aston.kovaleva.entries.Cat;
import ru.aston.kovaleva.entries.HomeCat;
import ru.aston.kovaleva.entries.WildCat;

public class GenericBounded<T extends Cat> {

    private static final Logger logger = LoggerFactory.getLogger(GenericBounded.class);

    private final T cat;

    public GenericBounded(T cat) {
        this.cat = cat;
    }

    public static void main(String[] args) {

        //GenericBounded<Animal> genericBounded = new GenericBounded<>(); //ошибка
        GenericBounded<Cat> cat = new GenericBounded<>(new Cat());
        GenericBounded<HomeCat> homeCat = new GenericBounded<>(new HomeCat("Vasya"));
        GenericBounded<WildCat> wildCat = new GenericBounded<>(new WildCat("Manul"));

        cat.action();
        homeCat.action();
        wildCat.action();
    }

    private void action() {
        String actionResult = cat.getMyau();
        logger.info("actionResult:{}", actionResult);
    }
}
