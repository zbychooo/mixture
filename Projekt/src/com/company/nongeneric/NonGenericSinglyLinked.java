package com.company.nongeneric;

class Node {
    Object value;
    Node next;

    Node(Object v) {
        this.value = v;
    }
}

interface NonGenericSingleLinkable {
    void add(Object object);
    Object get(int index);
    int size();
}



public class NonGenericSinglyLinked implements NonGenericSingleLinkable {

    private Node head;
    private int size;

    @Override
    public void add(Object object) {

        if(head == null) {
            head = new Node(object);
        } else {

            Node node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node(object);
        }
        size++;
    }

    @Override
    public Object get(int index) {

        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }
}








