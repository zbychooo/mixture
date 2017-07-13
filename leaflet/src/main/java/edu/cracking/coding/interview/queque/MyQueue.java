package edu.cracking.coding.interview.queque;

public class MyQueue<E> implements Queueable<E> {

    Element<E> head;
    Element<E> tail;

    private int size;


    @Override
    public void enqueue(E e) {

        if (head == null) {
            head = new Element<>(e);
            tail = head;
        } else {

            Element element = new Element<>(e);
            tail.next = element;
            tail = element;
            tail.next = null;
        }

        this.size++;
    }

    @Override
    public E dequeue() {

        if (size == 0) {
            return null;
        }

        Element<E> e = head;
        if(size == 1) {

            head = null;
            tail = null;
        } else {
            head = e.next;
        }


        this.size--;
        return e.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }


    private class Element<E> {

        E element;
        Element<E> next;

        Element(E e) {
            this.element = e;
        }
    }
}
