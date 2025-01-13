package ru.aston.kovaleva;

/**
 * Interface for working with CustomArrayList, CustomLinkedList
 * @param <E> type of elements contained in the lists
 */
public interface CustomList<E> {

    /**
     * Adds an item to the end of the list.
     */
    void add(E e);

    /**
     * Adds an element at the specified index.
     * @param index index.
     * @param e added element.
     */
    void add(int index, E e);

    /**
     * Returns the number of elements in this list.
     * @return the number of elements.
     */
    int getSize();

    /**
     * Returns a collection element by index.
     * @param index index.
     * @return collection element.
     */
    E get(int index);

    /**
     * Clears the entire collection.
     */
    void clear();

    /**
     * Deletes an element of the collection by index.
     * @param index index.
     */
    void remove(int index);

    /**
     * Removes an element by value.
     * @param e value of the element being searched for.
     */
    void removeByValue(E e);

    /**
     * Sorts the elements of the collection in natural order.
     * @param c comp.
     */
    void sort(CustomComparator<? super E> c);
}
