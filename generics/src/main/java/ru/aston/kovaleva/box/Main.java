package ru.aston.kovaleva.box;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Box box1 = new Box(10);
        Box box2 = new Box(20);

        box1.setObj("A");

        //int result = (Integer) box1.getObj() + (Integer) box2.getObj();

        //до появления дженериков делали касты и проверки, чтобы случайно не словить ClassCastException
        //оператор instanceof используется для проверки, является ли объект экземпляром определенного класса или интерфейса
        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
            int result = (Integer) box1.getObj() + (Integer) box2.getObj();
            logger.info("{}", result);
        }

        //logger.info("{}", result);

        //дженерики
        BoxGeneric<Integer> boxGeneric1 = new BoxGeneric<>(10);
        BoxGeneric<Integer> boxGeneric2 = new BoxGeneric<>(20);

        //комплятор сразу преобразует числа в Integer.valueOf(10) и Integer.valueOf(20)
        int resultGeneric = boxGeneric1.getT() + boxGeneric2.getT();

        logger.info("{}", resultGeneric);

        //Ограничения на Дженерики
        //Нельзя создать экземпляр обобщенного типа с помощью примитивных типов
        //BoxGeneric<int> boxGenericInt = new BoxGeneric<int>(3);

        //Нельзя объявить поля в том числе и статические, типы которых являются обобщенными, смотри на примере класса

        //Нельзя использовать касты или instanceof с обобщенными типами

//        if (boxGeneric1.getT() instanceof boxGeneric2.getT()) {
//
//        }

        //Нельзя создавать массивы обобщенного типа
        //BoxGeneric<Integer>[] boxGenericsArray = new BoxGeneric<Integer>[];

        //Нельзя создавать, перехватывать, или выбрасывать обобщенные исключения (посмотрим пример из документации)

    }

    // В классе не может быть двух перегруженных методов с одинаковой сигнатурой после стирания типов

    //public void print(Set<String> strSet) {}

    //public void print(Set<Integer> intSet) {}
}
