package kz.sabyrzhan.algo.leetcode.problems.p704;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    BinarySearch search = new BinarySearch();

    @Test
    void test1() {
        int[] values = new int[] {-1,0,3,5,9,12};
        int result = search.search(values, 9);
        assertEquals(4, result);
    }

    @Test
    void test2() {
        int[] values = new int[] {-1,0,3,5,9,12};
        int result = search.search(values, 2);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        int[] values = new int[] {5};
        int result = search.search(values, -5);
        assertEquals(-1, result);
    }

    @Test
    void test4() {
        int[] values = new int[] {2,5};
        int result = search.search(values, 5);
        assertEquals(1, result);
    }
}