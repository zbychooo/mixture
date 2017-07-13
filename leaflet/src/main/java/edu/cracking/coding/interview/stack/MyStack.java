package edu.cracking.coding.interview.stack;


public class MyStack<E> implements Stackable<E> {

    private int size;
    Node<E> top;

    @Override
    public int size() {
        return size;
    }

    @Override
    public E pop() {

        Node<E> node = top;
        top = top.next;
        size--;
        return node.element;
    }

    @Override
    public void push(E e) {

        if(top == null) {
            top = new Node<>(e);
        } else {
            Node oldTop = top;
            top = new Node<>(e);
            top.next = oldTop;
        }


        size++;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private class Node<E> {

        E element;
        Node<E> next;

        Node(E e) {
            this.element = e;
        }
    }
}
