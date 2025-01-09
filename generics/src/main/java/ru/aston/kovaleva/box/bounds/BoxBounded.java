package ru.aston.kovaleva.box.bounds;

import java.util.ArrayList;
import java.util.List;

public class BoxBounded<T extends Fruit> {

    private List<T> fruits;

    public BoxBounded() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        if (fruit == null || fruits == null) {
            System.out.println("Невозможно добавить.");
        } else {
            fruits.add(fruit);
        }
    }

    public int weight() {
        if (fruits == null) {
            return 0;
        }
        int mainWeight = 0;
        for (T fruit : fruits) {
            mainWeight += fruit.weight;
        }
        return mainWeight;
    }

    public boolean compare(BoxBounded<?> box) {
        return this.weight() == box.weight();
    }

    public static <T extends Fruit> void pour(BoxBounded<? super T> boxOne, BoxBounded<? extends T> boxTwo) {
        if (boxOne == null || boxTwo == null || boxOne == boxTwo) {
            System.out.println("Невозможно пересыпать.");
        } else {
            for (T fruit : boxTwo.fruits) {
                boxOne.addFruit(fruit);
            }
            boxTwo.fruits.clear();
        }
    }
}
