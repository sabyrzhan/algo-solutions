package kz.sabyrzhan.algo.leetcode.problems.p16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeSumClosestTest {
    TreeSumClosest sum = new TreeSumClosest();

    @Test
    public void sum_success() {
        int result = sum.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        assertEquals(2, result);
    }
}