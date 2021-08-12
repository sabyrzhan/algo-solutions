package kz.sabyrzhan.algo.java8.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {
    @Test
    public void testCopy() {
        List<Integer> dst = Arrays.asList(IntStream.range(1, 21).boxed().toArray(Integer[]::new));
        List<Integer> src = Arrays.asList(IntStream.range(21,41).boxed().toArray(Integer[]::new));
        Collections.copy(dst, src);

        assertEquals(Arrays.asList(IntStream.range(21,41).boxed().toArray(Integer[]::new)), dst);
    }
}
