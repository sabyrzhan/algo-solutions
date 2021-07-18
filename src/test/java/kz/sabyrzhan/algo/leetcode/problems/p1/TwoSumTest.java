package kz.sabyrzhan.algo.leetcode.problems.p1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    @Test
    public void twoSum_success() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0,1}, result);
    }

    @Test
    public void twoSum_success2() {
        int[] result = twoSum.twoSum(new int[]{3,2,4}, 6);
        assertArrayEquals(new int[]{1,2}, result);
    }

    @Test
    public void twoSum_success3() {
        int[] result = twoSum.twoSum(new int[]{3,3}, 6);
        assertArrayEquals(new int[]{0,1}, result);
    }

    @Test
    public void twoSum_notFound() {
        int[] result = twoSum.twoSum(new int[]{3,3}, 7);
        assertNull(result);
    }
}