package kz.sabyrzhan.algo.data_structures;

import java.util.Iterator;

public class ArrayList implements Iterable<Object> {
    private Object[] items;
    private int capacity = 16;
    private int len = 0;

    public ArrayList() {
        items = new Object[capacity];
    }

    public ArrayList(int cap) {
        this.capacity = cap;
        this.items = new Object[cap];
    }

    public void add(Object item) {
        if (len >= capacity) {
            capacity *= 2;
            Object[] newItems = new Object[capacity];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            newItems[len++] = item;
            items = newItems;
        } else {
            items[len++] = item;
        }
    }

    public Object get(int index) {
        if (index >= items.length) {
            return new IndexOutOfBoundsException("index is out of " + capacity + " length");
        }
        return items[index];
    }

    public void remove(Object o) {
        int newLen = len;
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (o.equals(items[i])) {
                i++;
                newLen--;
            }
            items[j] = items[i];
        }
        if (newLen != len) {
            items[len - 1] = null;
        }
        len = newLen;
    }

    public void remove(int i) {
        if (i >= capacity) {
            throw new IndexOutOfBoundsException();
        }

        if (i == capacity - 1) {
            items[i] = null;
            return;
        }

        for (int j = i + 1; j < capacity; j++, i++) {
            items[i] = items[j];
        }
        len--;
    }

    public int size() {
        return len;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < len;
            }

            @Override
            public Object next() {
                return items[i++];
            }
        };
    }
}
