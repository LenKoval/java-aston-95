package ru.aston.kovaleva.box.bounds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ru.aston.kovaleva.box.bounds.BoxBounded.pour;

public class FruitBoxBoundedApp {

    public static final Logger logger = LoggerFactory.getLogger(FruitBoxBoundedApp.class);

    public static void main(String[] args) {
        BoxBounded<Apple> appleBox = new BoxBounded<>();
        BoxBounded<Apple> appleBox1 = new BoxBounded<>();
        BoxBounded<Orange> orangeBox = new BoxBounded<>();
        BoxBounded<Fruit> fruitBox = new BoxBounded<>();

        for (int i = 0; i < 30; i++) {
            Apple apple = new Apple();
            appleBox.addFruit(apple);
        }

        for (int i = 0; i < 10; i++) {
            Apple apple = new Apple();
            appleBox1.addFruit(apple);
        }

        for (int i = 0; i < 60; i++) {
            Orange orange = new Orange();
            orangeBox.addFruit(orange);
        }

        for (int i = 0; i < 20; i++) {
            Apple apple = new Apple();
            Orange orange = new Orange();
            fruitBox.addFruit(apple);
            fruitBox.addFruit(orange);
        }

        //проверяем вес заполненных коробок
        logger.info("{}", appleBox.weight());
        logger.info("{}", orangeBox.weight());
        logger.info("{}", fruitBox.weight());

        //случаи для проверки
        BoxBounded<Apple> appleBox2 = null;
        Apple apple = new Apple();
        Orange orange = null;

        fruitBox.addFruit(apple);
        appleBox.addFruit(apple);
        orangeBox.addFruit(orange); // не пройдет проверку
        logger.info("{}", appleBox.compare(orangeBox));
        pour(fruitBox, appleBox1);
        pour(appleBox1, appleBox);
        pour(appleBox2, appleBox); // не пройдет проверку
        pour(appleBox, appleBox); // не пройдет проверку
        //pour(appleBox1, orangeBox); // не сработает
        //pour(orangeBox, fruitBox); // не сработает
    }
}
