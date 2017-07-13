package edu.cracking.coding.interview.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is leaflet. Good Luck!
 */
public class MyStackTest {
    @Test
    public void pop() throws Exception {

        Stackable<String> strings = new MyStack<>();
        strings.push("test");
        strings.push("test1");
        strings.push("test2");
        assertEquals(3, strings.size());

        assertEquals("test2", strings.pop());
        assertEquals("test1", strings.pop());
        assertEquals("test", strings.pop());
        assertTrue(strings.isEmpty());
    }

    @Test
    public void push() throws Exception {

        Stackable<String> strings = new MyStack<>();
        strings.push("test");
        assertFalse(strings.isEmpty());
        assertEquals(1,strings.size());

        strings.push("test1");
        strings.push("test2");
        assertEquals(3, strings.size());
    }

}