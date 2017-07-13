package edu.cracking.coding.interview.queque;

interface Queueable<E> {

    void enqueue(E e);
    E dequeue();
    int size();
    boolean isEmpty();
}
