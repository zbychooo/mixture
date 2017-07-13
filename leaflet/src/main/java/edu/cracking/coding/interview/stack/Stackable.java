package edu.cracking.coding.interview.stack;

/**
 * This is leaflet. Good Luck!
 */
interface Stackable<E> {

    int size();

    E pop();

    void push(E e);

    boolean isEmpty();
}
