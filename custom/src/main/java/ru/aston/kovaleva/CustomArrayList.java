package ru.aston.kovaleva;

/**
 * Implementation of custom ArrayList
 * @param <E> type of data stored in the array
 */
@SuppressWarnings("unchecked")
public class CustomArrayList<E> implements CustomList<E> {

    /**
     * Initial default capacity
     */
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Actual capacity
     */
    private int capacity;

    /**
     * Array of objects for storing items
     */
    private E[] elements;

    /**
     * Number of elements in CustomArrayList
     */
    private int size;

    /**
     * Creates an empty list with a specified initial capacity.
     * If capacity = 0, the default value is set.
     *
     * @param initialCapacity initial capacity of the list.
     * @throws IllegalArgumentException if negative initial capacity is specified.
     */
    public CustomArrayList(int initialCapacity) {
        size = 0;
        if (initialCapacity > 0) {
            this.capacity = initialCapacity;
            this.elements = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.capacity = INITIAL_CAPACITY;
            this.elements = (E[]) new Object[INITIAL_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    /**
     * Creating an empty list with an initial capacity = 10
     */
    public CustomArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Inserting an element at the end of CustomArrayList.
     * The array storing the elements is expanded as needed.
     * @param e element to insert.
     */
    @Override
    public void add(E e) {
        expendArray();
        elements[size++] = e;
    }

    /**
     * Inserting an element by index.
     * @param index index to insert the element.
     * @param e element to insert at the specified position.
     */
    //@SuppressWarnings("ReassignedVariable")
    @Override
    public void add(int index, E e) {
        size++;
        checkIndex(index);
        expendArray();

        E temp = e, temp2;
        for(int i = index; i < size; i++) {
            temp2 = elements[i];
            elements[i] = temp;
            temp = temp2;
        }
    }

    /**
     * Returns the number of elements of the collection.
     * @return the number of elements of the collection.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Getting an element by index
     * @param index index of the element being searched.
     * @return Returns the value of the element by index.
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Clear CustomArrayList, sets the default capacity.
     */
    @Override
    public void clear() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Deleting an element by index.
     * @param index of the element to be deleted.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        int moved = size-index-1;
        System.arraycopy(elements, index + 1, elements, index, moved);
        size--;
    }

    /**
     * Deleting an element by value.
     * @param value of the element to be deleted.
     */
    @Override
    public void removeByValue(E value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                remove(i);
                break;
            }
        }
    }

    /**
     * Sorts the list using the passed comparator.
     * @param c comparator for sorting list items
     */
    @Override
    public void sort(CustomComparator<? super E> c) {
        if (size > 1) {
            insertionSort(elements, size, c);
        }
    }

    /**
     * Check index for correctness.
     * @param index the index to be checked.
     */
    private void checkIndex(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size);
        }
    }

    /**
     * Expands the array when it is full.
     */
    private void expendArray() {
        if(size == capacity) {
            int newCapacity = (capacity * 3) / 2 + 1;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = (E[]) newArray;
            capacity = newCapacity;
        }
    }

    /**
     * Realizes sorting by inserts.
     * @param array of elements for sorting
     * @param size number of elements for sorting
     * @param c comparator for comparing elements
     */
    private void insertionSort(E[] array, int size, CustomComparator<? super E> c) {
        for (int i = 1; i < size; i++) {
            E key = array[i];
            int j = i - 1;
            while (j >= 0 && c.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Checks if the array is empty or not
     * @return true if the array is empty, returns false if the array is not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
