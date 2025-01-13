package ru.aston.kovaleva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    @Test
    public void shouldAddItemToEmptyList() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("First");
        assertEquals(1, list.getSize());
        assertEquals("First", list.get(0));
    }

    @Test
    public void shouldAddMultipleItemsToEmptyList() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void shouldAddItemsByIndex() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add(0, "First");
        list.add(1, "Second");
        assertEquals(2, list.getSize());
        assertEquals("Second", list.get(0));
        assertEquals("First", list.get(1));
    }

    @Test
    public void shouldSortTheList() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        list.sort((a, b) -> Integer.compare(a, b));

        assertEquals(4, list.getSize());
        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)2, list.get(1));
        assertEquals((Integer)5, list.get(2));
        assertEquals((Integer)8, list.get(3));

        CustomArrayList<Double> doubleList = new CustomArrayList<>();
        doubleList.add(5.5);
        doubleList.add(2.2);
        doubleList.add(8.8);
        doubleList.add(1.1);
        doubleList.sort((a, b) -> Double.compare(a, b));
        assertEquals((Double)1.1, doubleList.get(0));
        assertEquals((Double)2.2, doubleList.get(1));
        assertEquals((Double)5.5, doubleList.get(2));
        assertEquals((Double)8.8, doubleList.get(3));
    }

    @Test
    public void shouldRemoveItem() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Test");
        list.remove(0);
        assertEquals(0, list.getSize());
    }

    @Test
    public void shouldRemoveItemByValue() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Test");
        list.removeByValue("Test");
        assertEquals(0, list.getSize());
    }

    @Test
    public void shouldCheckThatListIsEmpty() {
        CustomArrayList<String> list = new CustomArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldCheckThatListIsNotEmpty() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Test");
        assertFalse(list.isEmpty());
    }

    @Test
    public void shouldCheckThatListIsClear() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Test");
        list.clear();
        assertTrue(list.isEmpty());
    }
}
