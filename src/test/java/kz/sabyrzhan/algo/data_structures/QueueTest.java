package kz.sabyrzhan.algo.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    public void add_success() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        assertEquals(4, queue.size);
        assertEquals(1, queue.head.getValue());
        assertEquals(4, queue.tail.getValue());
    }

    @Test
    public void peek_success() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int result = queue.peek();

        assertEquals(1, result);
        assertEquals(3, queue.size);
    }

    @Test
    public void poll_success() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int result = queue.poll();

        assertEquals(1, result);
        assertEquals(2, queue.size);
        assertEquals(2, queue.head.getValue());
        assertEquals(3, queue.tail.getValue());
    }

    @Test
    public void poll_emptyNull() {
        try {
            queue.poll();
            fail();
        } catch (RuntimeException e) {
            assertEquals("empty queue", e.getMessage());
        }
    }
}
