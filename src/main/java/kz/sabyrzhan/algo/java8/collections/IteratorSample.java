package kz.sabyrzhan.algo.java8.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSample {
    private List<String> items = new ArrayList<>();

    public void add(String item) {
        this.items.add(item);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex + 1 < items.size();
            }

            @Override
            public String next() {
                return items.get(currentIndex++);
            }

            @Override
            public void remove() {
                if (currentIndex - 1 >= 0) {
                    items.remove(currentIndex - 1);
                }
            }
        };
    }
}
