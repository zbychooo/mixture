package edu.cracking.coding.interview.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is leaflet. Good Luck!
 */
public class DoubleLinkedTest {
    @Test
    public void delete() throws Exception {

        MyCollection<String> strings = new DoubleLinked<>();
        strings.add("root");
        strings.add("second");
        strings.add("third");
        strings.add("forth");
        assertEquals(4, strings.size());

        strings.delete(0);
        assertEquals(3, strings.size());
        strings.delete(1);
        assertEquals(2, strings.size());


    }

    @Test
    public void add() throws Exception {

        MyCollection<String> strings = new DoubleLinked<>();
        strings.add("root");
        assertEquals(1, strings.size());
        strings.add("second");
        assertEquals(2, strings.size());
    }

}