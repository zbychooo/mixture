package edu.cracking.coding.interview.queque;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {


    @Test
    public void enqueue() throws Exception {

        Queueable<String> strings = new MyQueue<>();
        strings.enqueue("test");
        strings.enqueue("test2");
        assertFalse(strings.isEmpty());
        assertEquals(2, strings.size());


    }

    @Test
    public void dequeue() throws Exception {

        Queueable<String> strings = new MyQueue<>();
        strings.enqueue("test");
        strings.enqueue("test2");
        strings.enqueue("test3");

        assertEquals("test", strings.dequeue());
        assertEquals("test2", strings.dequeue());
        assertEquals("test3", strings.dequeue());

        assertTrue(strings.isEmpty());
    }

}