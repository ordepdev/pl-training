package com.ordepdev.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericCircularBufferTest {

    private GenericCircularBuffer<String> buffer = new GenericCircularBuffer<String>(2);

    @Test
    public void shouldOfferPollableElement() {
        assertTrue(buffer.offer("a"));
        assertEquals("a", buffer.poll());
        assertNull(buffer.poll());
    }

    @Test
    public void shouldNotOfferPollableElementWhenBufferIsFull() {
        assertTrue(buffer.offer("a"));
        assertTrue(buffer.offer("b"));
        assertFalse(buffer.offer("c"));
    }

    @Test
    public void shouldNotPollWhenBufferIsEmpty() {
        assertNull(buffer.poll());
    }

    @Test
    public void shouldRecycleBuffer() {
        assertTrue(buffer.offer("a"));
        assertTrue(buffer.offer("b"));
        assertEquals("a", buffer.poll());
        assertTrue(buffer.offer("c"));
        assertEquals("b", buffer.poll());
        assertEquals("c", buffer.poll());
        assertNull(buffer.poll());
    }
}
