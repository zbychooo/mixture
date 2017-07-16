package edu.cracking.coding.interview.heap;

/**
 * This is leaflet. Good Luck!
 */
public class Heap<E> {

    private Node<E> root;
    int size;

    public <E> void insert(E e) {

        if(root == null) {
            root = new Node(e);
        } else {

            Node temp = root;

            while(temp.left == null || temp.right == null) {

                //if()
            }

        }


        size++;
    }

    public <E> E get(E e) {
        return null;
    }

    private class Node<E> {

        E value;
        Node<E> left;
        Node<E> right;

        Node(E e) {
            this.value = e;
        }
    }
}
