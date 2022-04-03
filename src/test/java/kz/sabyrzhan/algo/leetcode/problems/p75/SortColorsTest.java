package kz.sabyrzhan.algo.leetcode.problems.p75;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortColorsTest {
    SortColors sort = new SortColors();

    @Test
    void test1() {
        int[] v = new int[] { 2,0,2,1,1,0 };
        sort.sortColors(v);
        assertArrayEquals(new int[] {0,0,1,1,2,2}, v);
    }

    @Test
    void test2() {
        int[] v = new int[] {2,0,1};
        sort.sortColors(v);
        assertArrayEquals(new int[] {0,1,2}, v);
    }
}