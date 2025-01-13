package ru.aston.kovaleva;

/**
 * Implementation of custom LinkedList
 * @param <E> type of data stored in the list
 */
public class CustomLinkedList<E> implements CustomList<E> {

    /**
     * The first node in the CustomLinkedList.
     */
    private Node<E> head;

    /**
     * The last node in the CustomLinkedList.
     */
    private Node<E> tail;

    /**
     * The number of elements stored in the list.
     */
    private int size;

    /**
     * Creating an empty CustomLinkedList.
     */
    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * An inner class representing a node in a linked list.
     * @param <E> the data type stored in the node.
     */
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Adds an item to the end of the CustomLinkedList.
     * @param e the element being added.
     */
    @Override
    public void add(E e) {
        if (head == null && tail == null) {
            head = new Node<>(null, e, null);
            tail = head;
        } else if (head == tail){
            tail = new Node<>(head, e, null);
            head.next = tail;
        } else {
            Node<E> temp = tail;
            tail = new Node<>(temp, e, null);
            temp.next = tail;
        }
        size++;
    }

    /**
     * Adds an element by index.
     * @param index the index by which the element is inserted.
     * @param e the element being added.
     */
    @Override
    public void add(int index, E e) {
        checkIndex(index);
        Node<E> temp = getNode(index);
        Node<E> tempPrev = temp.prev;
        Node<E> newE = new Node<>(temp.prev, e, temp);
        if(tempPrev != null) {
            tempPrev.next = newE;
        }
        temp.prev = newE;
        if (index == 0) {
            head = newE;
        }
        size++;
    }

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Retrieving an element by index.
     * @param index of the element to retrieve.
     * @return element by the specified index.
     */
    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    /**
     * Clearing the list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Deleting an element by the specified index.
     * @param index of the element to be deleted.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        Node<E> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<E> prevNode = getNode(index - 1);
            removedNode = prevNode.next;
            prevNode.next = removedNode.next;
            if (removedNode.next == null) {
                tail = prevNode;
            }
        }

        size--;
    }

    /**
     * Deleting an element by value.
     * @param e selected value.
     */
    @Override
    public void removeByValue(E e) {
        Node<E> current = head;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(e)) {
                index = i;
                break;
            }
            current = current.next;
        }
        remove(index);
    }

    /**
     * Sorts the list using the passed comparator.
     * @param c comparator to sort list items.
     */
    @Override
    public void sort(CustomComparator<? super E> c) {
        if (size > 1) {
            head = mergeSort(head, c);
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            tail = current;
        }
    }

    /**
     * Check index for correctness.
     * @param index the index to be checked.
     */
    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
        }
    }

    /**
     * Returns the node at the specified index.
     * @param index index of the node to return.
     * @return the node at the specified index.
     */
    private Node<E> getNode(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Merge Sort
     * @param head initial sublist node for sorting.
     * @param c comparator for comparing elements.
     * @return sorted list.
     */
    private Node<E> mergeSort(Node<E> head, CustomComparator<? super E> c) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<E> middle = getMiddle(head);
        Node<E> nextOfMiddle = middle.next;
        middle.next = null;
        Node<E> left = mergeSort(head, c);
        Node<E> right = mergeSort(nextOfMiddle, c);
        return sortedMerge(left, right, c);
    }

    /**
     * Combining two sorted lists.
     * @param left left sublist.
     * @param right right sublist.
     * @param c comparator to compare elements.
     * @return merged sorted list.
     */
    private Node<E> sortedMerge(Node<E> left, Node<E> right, CustomComparator<? super E> c) {
        Node<E> result;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (c.compare(left.data, right.data) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right, c);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next, c);
        }
        return result;
    }

    /**
     * Get the middle node of the list.
     * @param head the initial node of the list.
     * @return middle node of the list.
     */
    private Node<E> getMiddle(Node<E> head) {
        if (head == null) {
            return head;
        }
        Node<E> slow = head;
        Node<E> fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    /**
     * Checks if the list is empty or not
     * @return true if the list is empty, returns false if the list is not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
