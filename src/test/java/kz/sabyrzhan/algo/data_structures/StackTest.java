package kz.sabyrzhan.algo.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    LinkedList<Object> container;
    Stack stack;

    @BeforeEach
    void setUp() {
        container = new LinkedList<>();
        stack = new Stack(container);
    }

    @Test
    public void push_success() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, container.size());
        assertEquals(3, container.removeLast());
        assertEquals(2, container.removeLast());
        assertEquals(1,container.removeLast());
    }

    @Test
    public void pop_success() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();

        assertEquals(2, container.size());
        assertEquals(2, container.removeLast());
        assertEquals(1, container.removeLast());
    }

    @Test
    public void peek_success() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.peek();

        assertEquals(3, container.size());
        assertEquals(3, container.removeLast());
        assertEquals(2, container.removeLast());
        assertEquals(1, container.removeLast());
    }
}

