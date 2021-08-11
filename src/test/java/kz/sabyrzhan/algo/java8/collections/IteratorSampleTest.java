package kz.sabyrzhan.algo.java8.collections;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class IteratorSampleTest {
    IteratorSample sample = new IteratorSample();

    @Test
    public void iterate_success() {
        sample.add("1");
        sample.add("2");
        sample.add("3");
        sample.add("4");
        sample.add("5");

        Iterator<String> it = sample.iterator();
        String[] expected = {"1","2","3","4", "5"};
        int index = 0;
        while(it.hasNext()) {
            assertEquals(expected[index++], it.next());
        }

        assertFalse(it.hasNext());
    }

    @Test
    public void iterateRemove_success() {
        sample.add("1");
        sample.add("2");
        sample.add("3");
        sample.add("4");
        sample.add("5");

        Iterator<String> it = sample.iterator();
        while(it.hasNext()) {
            String val = it.next();
            if (val.equals("3")) {
                it.remove();
            }
        }

        it = sample.iterator();
        String[] expected = {"1","2","4","5"};
        int index = 0;
        while(it.hasNext()) {
            String val = it.next();
            assertEquals(expected[index++], val);
        }
    }
}