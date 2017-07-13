package edu.cracking.coding.interview.linkedlist;

/**
 * This is leaflet. Good Luck!
 */
public class DoubleLinked<E> implements MyCollection<E> {

    private int size;
    private Node<E> root;

    @Override
    public void add(E e) {

        if(root == null) {
            root = new Node<>(e);
            root.prev = null;
            root.next = null;
        } else {

            Node node = root;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(e);
            node.next.prev = node;
        }

        size++;
    }

    @Override
    public E get(int index) {
        //TODO:
        return null;
    }

    @Override
    public void set(int index, E e) {
        //TODO:
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
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

        if(index == 0) {
            root = root.next;
            root.prev = null;
        } else {

            int counter = 1;
            Node item = root;
            while(counter == index) {
                item = item.next;
                counter++;
            }
            Node next = item.next;
            item.prev.next = next;
        }
        size--;
    }

    @Override
    public void addAll(MyCollection<? extends E> collection) {

    }

    private class Node<E> {

        E element;
        Node<E> next;
        Node<E> prev;

        Node(E e) {
            this.element = e;
        }
    }


}
