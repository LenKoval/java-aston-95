package ru.aston.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aston.kovaleva.entries.Animal;
import ru.aston.kovaleva.entries.Cat;
import ru.aston.kovaleva.entries.HomeCat;
import ru.aston.kovaleva.entries.WildCat;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcard {

    private static final Logger logger = LoggerFactory.getLogger(GenericWildcard.class);

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());

        print(animalList);
        printWild(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new HomeCat("Барсик"));
        catList.add(new WildCat("Багира"));

        //print(catList); //Ошибка
        printWild(catList);
    }

    // Нельзя передать сюда List<Cat>
    private static void print(List<Animal> animalList) {
        animalList.forEach(animal -> logger.info("{}", animal));
    }

    private static void printWild(List<? extends Animal> animalList) {
        animalList.forEach(animal -> logger.info("{}", animal));
    }
}
