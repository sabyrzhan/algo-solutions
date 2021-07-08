package kz.sabyrzhan.algo.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LinkedListTest {
    LinkedList list;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
    }

    @Test
    public void add_success() {
        list.add(1);

        assertNotNull(list.head);
        assertNotNull(list.tail);
        assertEquals(list.head, list.tail);
        assertEquals(1, list.head.getValue());
        assertEquals(1, list.size);
    }

    @Test
    public void add_success_multi_elements() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertNotNull(list.head);
        assertNotNull(list.tail);
        assertEquals(4, list.size);

        int i = 1;
        for(int value: list) {
            assertEquals(i,value);
            i++;
        }
        assertEquals(i, 5);
    }

    @Test
    public void addFirst_success() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.addFirst(0);

        assertEquals(5, list.size);

        int i = 0;
        for (int value: list) {
            assertEquals(i++, value);
        }
        assertEquals(5, i);
    }

    @Test
    public void addLast_success() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.addLast(5);

        assertEquals(5, list.size);

        int i = 1;
        for (int value: list) {
            assertEquals(i++, value);
        }
        assertEquals(6, i);
    }

    @Test
    public void removeFirst_success() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeFirst();

        assertEquals(3, list.size);

        int i = 2;
        for (int value: list) {
            assertEquals(i++, value);
        }
        assertEquals(5, i);
    }

    @Test
    public void removeLast_success() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeLast();

        assertEquals(3, list.size);

        int i = 1;
        for (int value: list) {
            assertEquals(i++, value);
        }
        assertEquals(4, i);
    }

    @Test
    public void remove_success() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(3);

        assertEquals(3, list.size);

        int i = 0;
        int[] expected = {1,2,4};
        for (int value: list) {
            assertEquals(expected[i++], value);
        }
    }

    @Test
    public void removeAtIndex_success() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeAtIndex(1);

        assertEquals(3, list.size);

        int i = 0;
        int[] expected = {1,3,4};
        for (int value: list) {
            assertEquals(expected[i++], value);
        }
    }
}
