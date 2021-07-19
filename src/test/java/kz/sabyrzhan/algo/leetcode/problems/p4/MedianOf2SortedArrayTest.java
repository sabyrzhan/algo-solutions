package kz.sabyrzhan.algo.leetcode.problems.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOf2SortedArrayTest {
    MedianOf2SortedArray runner = new MedianOf2SortedArray();

    @Test
    public void finder_success() {
        int[] num1 = {1,3};
        int[] num2 = {2};
        double result = runner.findMedianSortedArrays(num1, num2);
        assertEquals(2, result);
    }

    @Test
    public void finder_success2() {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        double result = runner.findMedianSortedArrays(num1, num2);
        assertEquals(2.5, result);
    }

    @Test
    public void finder_success3() {
        int[] num1 = {0,0};
        int[] num2 = {0,0};
        double result = runner.findMedianSortedArrays(num1, num2);
        assertEquals(0, result);
    }

    @Test
    public void finder_success4() {
        int[] num1 = {};
        int[] num2 = {1};
        double result = runner.findMedianSortedArrays(num1, num2);
        assertEquals(1, result);
    }

    @Test
    public void finder_success5() {
        int[] num1 = {2};
        int[] num2 = {};
        double result = runner.findMedianSortedArrays(num1, num2);
        assertEquals(2, result);
    }

    @Test
    public void finder_success6() {
        int[] num1 = {};
        int[] num2 = {};
        double result = runner.findMedianSortedArrays(num1, num2);
        assertEquals(0, result);
    }
}
