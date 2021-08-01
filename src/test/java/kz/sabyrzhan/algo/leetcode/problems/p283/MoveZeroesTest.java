package kz.sabyrzhan.algo.leetcode.problems.p283;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {
    MoveZeroes mv = new MoveZeroes();

    @Test
    public void mv_success() {
        int[] nums = {0, 1, 0, 3, 12};
        mv.moveZeroes(nums);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums);
    }

    @Test
    public void mv_success2() {
        mv.moveZeroes(new int[]{0});
        assertArrayEquals(new int[]{0}, new int[]{0});
    }
}