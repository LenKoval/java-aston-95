package ru.aston.kovaleva;

/**
 * Interface for comparing elements.
 * @param <E> type of elements to be compared
 */
public interface CustomComparator<E> {

    int compare(E o1, E o2);
}
