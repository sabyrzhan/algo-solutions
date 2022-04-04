package kz.sabyrzhan.algo.leetcode.problems.p66;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {
    PlusOne plus = new PlusOne();

    @Test
    void test1() {
        int[] result = plus.plusOne(new int[] {1,2,3});
        assertArrayEquals(new int[] {1,2,4}, result);
    }

    @Test
    void test2() {
        int[] result = plus.plusOne(new int[] {4,3,2,1});
        assertArrayEquals(new int[] {4,3,2,2}, result);
    }

    @Test
    void test3() {
        int[] result = plus.plusOne(new int[] {9});
        assertArrayEquals(new int[] {1,0}, result);
    }

    @Test
    void test4() {
        int[] result = plus.plusOne(new int[] {9,8,8});
        assertArrayEquals(new int[] {9,8,9}, result);
    }

    @Test
    void test5() {
        int[] result = plus.plusOne(new int[] {9,8,9});
        assertArrayEquals(new int[] {9,9,0}, result);
    }

    @Test
    void test6() {
        int[] result = plus.plusOne(new int[] {9,9,9});
        assertArrayEquals(new int[] {1,0,0,0}, result);
    }
}