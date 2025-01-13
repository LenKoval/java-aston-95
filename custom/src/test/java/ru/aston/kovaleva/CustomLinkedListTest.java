package ru.aston.kovaleva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {

    @Test
    public void shouldAddItemInEmptyList() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("First");
        assertEquals(1, list.getSize());
        assertEquals("First", list.get(0));
    }

    @Test
    public void shouldAddMultipleItemsInEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void shouldAddItemAtIndex() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("First");
        list.add("Second");
        list.add(1, "Test");
        assertEquals(3, list.getSize());
        assertEquals("Test", list.get(1));
    }

    @Test
    public void shouldSortTheLst() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
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

        CustomLinkedList<String> emptyList = new CustomLinkedList<>();
        emptyList.sort((a, b) -> Integer.compare(a.length(), b.length()));
        assertTrue(emptyList.isEmpty());

        CustomLinkedList<Double> doubleList = new CustomLinkedList<>();
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
    public void shouldRemoveItemByIndex() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Test");
        list.remove(0);
        assertEquals(0, list.getSize());
    }

    @Test
    public void shouldRemoveItemByValue() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Test");
        list.removeByValue("Test");
        assertEquals(0, list.getSize());
    }

    @Test
    public void shouldCheckThatListIsEmpty() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldCheckThatListIsNotEmpty() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Test");
        assertFalse(list.isEmpty());
    }
}
