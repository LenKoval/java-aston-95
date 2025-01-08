package ru.aston.kovaleva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DoubleGeneric<K, V> {

    private static final Logger logger = LoggerFactory.getLogger(DoubleGeneric.class);

    private final Map<K, V> map = new HashMap<>();

    public static void main(String[] args) {

        DoubleGeneric<Integer, String> doubleGeneric = new DoubleGeneric<>();
        doubleGeneric.putValue(1, "data1");
        doubleGeneric.putValue(2, "data2");
        doubleGeneric.putValue(3, "data3");
        // Ошибка компиляции:
        // doubleGeneric.putValue("4", "data4");

        doubleGeneric.print();

        DoubleGeneric<String, String> doubleGenericStr = new DoubleGeneric<>();
        doubleGenericStr.putValue("k1", "v1");
        doubleGenericStr.putValue("k2", "v2");
        doubleGenericStr.putValue("k3", "v3");

        doubleGenericStr.print();
    }

    private void putValue(K key, V val) {
        map.put(key, val);
    }

    private void print() {
        map.forEach((key, val) -> logger.info("key:{}, val:{}", key, val));
//        map.forEach(): Это метод коллекции Map, который применяет заданную операцию ко всем элементам карты.
//        (key, value) - это параметры лямбда-выражения. Они соответствуют ключу и значению пары в Map.
//        -> - это оператор стрелочной функции, разделяющий параметры лямбда-выражения от тела функции.
//        logger.info("key:{}, val:{}", key, value) - это тело лямбда-выражения, которое выполняется для каждой пары ключ-значение в Map.
    }
}
