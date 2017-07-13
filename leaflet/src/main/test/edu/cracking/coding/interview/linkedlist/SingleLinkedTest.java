package edu.cracking.coding.interview.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is leaflet. Good Luck!
 */
public class SingleLinkedTest {
    @Test
    public void shouldDeleteWhenHeadOnly() throws Exception {

        MyCollection<String> singleLinked = new SingleLinked<>();
        singleLinked.add("test");
        assertEquals(1, singleLinked.size());
        singleLinked.delete(0);
        assertEquals(0, singleLinked.size());


    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenDeleteEmptyList() throws Exception {

        MyCollection<String> singleLinked = new SingleLinked<>();
        assertTrue(singleLinked.isEmpty());
        singleLinked.delete(0);

    }

    @Test
    public void shouldDeleteWhenManyItems() throws Exception {

        MyCollection<String> singleLinked = new SingleLinked<>();
        singleLinked.add("test");
        singleLinked.add("test");
        singleLinked.add("test");
        singleLinked.add("test");
        assertEquals(4, singleLinked.size());
        singleLinked.delete(1);
        assertEquals(3, singleLinked.size());


    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void add() throws Exception {

        MyCollection<String> mySingleLinked = new SingleLinked<>();
        mySingleLinked.add("test");
        assertEquals(1, mySingleLinked.size());
        assertEquals("test", mySingleLinked.get(0));

    }

    @org.junit.Test
    public void get() throws Exception {
    }

    @org.junit.Test
    public void set() throws Exception {
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
    }

    @org.junit.Test
    public void clear() throws Exception {
    }

    @org.junit.Test
    public void size() throws Exception {
    }

    @org.junit.Test
    public void addAll() throws Exception {
    }

}