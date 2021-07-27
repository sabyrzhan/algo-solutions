package kz.sabyrzhan.algo.leetcode.problems.p209;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSubarrayLenTest {
    MinSubarrayLen len = new MinSubarrayLen();

    @Test
    public void min_success() {
        int res = len.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        assertEquals(2, res);
    }

    @Test
    public void min_success2() {
        int res = len.minSubArrayLen(4, new int[]{1,4,4});
        assertEquals(1, res);
    }

    @Test
    public void min_success3() {
        int res = len.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        assertEquals(0, res);
    }

    @Test
    public void min_success4() {
        int res = len.minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12});
        assertEquals(8, res);
    }
}
