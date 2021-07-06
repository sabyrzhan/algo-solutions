package kz.sabyrzhan.algo.data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    ArrayList list = new ArrayList();

    @Test
    public void add_success() {
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void getObject_success() {
        list.add("1");
        list.add("2");
        list.add("3");

        assertEquals(3, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
    }

    @Test
    public void removeObject_successRemoveFirst() {
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove("1");

        assertEquals(2, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
    }

    @Test
    public void removeObject_successRemoveLast() {
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove("3");

        assertEquals(2, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
    }

    @Test
    public void removeObject_successMiddle() {
        for(int i = 1; i <= 10; i++) {
            list.add(String.valueOf(i));
        }

        list.remove("3");
        list.remove("5");
        list.remove("7");

        assertEquals(7, list.size());
        String[] expected = {"1","2","4","6","8","9","10"};
        int i = 0;
        for(Object item : list) {
            assertEquals(expected[i++], item);
        }
    }

    @Test
    public void removeByIndex_successRemoveFirst() {
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove(0);

        assertEquals(2, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
    }

    @Test
    public void removeByIndex_successRemoveLast() {
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove(list.size() - 1);

        assertEquals(2, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
    }

    @Test
    public void removeByIndex_successRemoveMiddle() {
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals("1", list.get(0));
        assertEquals("3", list.get(1));
    }

    @Test
    public void getCapacity_success() {
        for(int i = 1; i<= 16;i++) {
            list.add(String.valueOf(i));
        }

        assertEquals(16, list.getCapacity());
        assertEquals(16, list.size());

        for(int i = 17; i <= 32; i++) {
            list.add(String.valueOf(i));
        }

        assertEquals(32, list.getCapacity());
        assertEquals(32, list.size());

        for(int i = 22; i <= 32; i++) {
            list.remove(String.valueOf(i));
        }

        assertEquals(32, list.getCapacity());
        assertEquals(21, list.size());

        int i = 1;
        for(Object item: list) {
            assertEquals(String.valueOf(i++), item);
        }

        assertEquals(22, i);
    }
}
