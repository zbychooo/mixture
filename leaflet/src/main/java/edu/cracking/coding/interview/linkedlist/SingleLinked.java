package edu.cracking.coding.interview.linkedlist;

public class SingleLinked<E> implements MyCollection<E> {

    private int size;
    private Node<E> head;

    @Override
    public void add(E e) {

        if (head == null) {
            head = new Node<>(e);
        } else {
            Node<E> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(e);
        }
        size++;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;

        while (index > 0) {
            node = node.next;
            index--;
        }

        return node.element;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || this.size < index) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;

        while (index > 0) {
            node = node.next;
            index--;
        }
        node.element = e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) {

        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;
        int counter = 0;

        if (index == 0) {

            if (this.size == 1) {
                clear();
            } else {
                head = head.next;
                size--;
            }
            return;
        }

        // iterate to the prev node
        while (counter == index - 1) {
            node = node.next;
            counter++;
        }

        if (node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        size--;

    }

    @Override
    public void addAll(MyCollection<? extends E> collection) {

        Node node = head;
        while (node.next != null) {
            node = node.next;
        }

        for (int i = 0; i < collection.size(); i++) {
            add(collection.get(i));
        }
    }

    private class Node<E> {

        E element;
        Node<E> next;

        Node(E e) {
            this.element = e;
        }
    }
}


interface MyCollection<E> {

    void add(E e);

    E get(int index);

    void set(int index, E e); //This an option! do not implement!

    boolean isEmpty();

    void clear();

    int size();

    void delete(int index);

    void addAll(MyCollection<? extends E> collection);
}






