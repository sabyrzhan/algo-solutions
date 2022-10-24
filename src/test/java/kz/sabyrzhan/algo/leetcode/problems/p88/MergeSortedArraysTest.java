package kz.sabyrzhan.algo.leetcode.problems.p88;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {
    MergeSortedArrays sort = new MergeSortedArrays();

    @Test
    void test1() {
        int[] a = new int[] { 1,2,3,0,0,0 };
        sort.merge(a, 3, new int[] { 2,5,6 }, 3);
        assertArrayEquals(new int[] {1,2,2,3,5,6}, a);
    }

    @Test
    void test2() {
        int[] a = new int[] {1};
        int[] b = new int[]{};
        sort.merge(a, 1, b, 0);
        assertArrayEquals(new int[] {1}, a);
    }

    @Test
    void test3() {
        int[] a = new int[] {0};
        int[] b = new int[] {1};
        sort.merge(a,0,b,1);
        assertArrayEquals(new int[]{1}, a);
    }

}