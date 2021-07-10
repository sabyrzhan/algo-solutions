package kz.sabyrzhan.algo.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LRUTest {
    LRU lru;

    @BeforeEach
    void setUp() {
        lru = new LRU(4);
    }

    @Test
    public void add_success() {
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);

        assertEquals(4, lru.values.size());
        assertEquals(4, lru.cacheValues.size());
        int i = 1;
        Iterator<NodeWithLeftAndRight> iterator = lru.cacheValues.iterator();
        for(;iterator.hasNext();) {
            assertEquals(i++, iterator.next().getValue());
        }
        assertEquals(5, i);
    }

    @Test
    public void add_successWithEvicted() {
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);

        assertEquals(4, lru.values.size());
        assertEquals(4, lru.cacheValues.size());
        int i = 2;
        Iterator<NodeWithLeftAndRight> iterator = lru.cacheValues.iterator();
        for(;iterator.hasNext();) {
            assertEquals(i++, iterator.next().getValue());
        }
        assertEquals(6, i);
    }

    @Test
    public void get_successWithEvicted() {
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);

        lru.get(3);

        assertEquals(4, lru.values.size());
        assertEquals(4, lru.cacheValues.size());
        int[] expected = {2,4,5,3};
        Iterator<NodeWithLeftAndRight> iterator = lru.cacheValues.iterator();
        for(int i = 0; iterator.hasNext() && i < expected.length; i++) {
            int expectedValue = expected[i];
            int actualValue = iterator.next().getValue();
            assertEquals(expectedValue, actualValue);
        }
    }

    @Test
    public void get_nonExistingElement() {
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);

        NodeWithLeftAndRight result = lru.get(5);

        assertNull(result);
    }
}
