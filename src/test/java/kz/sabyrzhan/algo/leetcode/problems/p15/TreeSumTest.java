package kz.sabyrzhan.algo.leetcode.problems.p15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeSumTest {
    ThreeSum sum = new ThreeSum();

    @Test
    public void sum_success() {
        List<List<Integer>> result = sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1,-1,2));
        expected.add(Arrays.asList(-1,0,1));

        assertEquals(expected, result);
    }

    @Test
    public void sum_success2() {
        List<List<Integer>> result = sum.threeSum(new int[]{});

        assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void sum_success3() {
        List<List<Integer>> result = sum.threeSum(new int[]{0});

        assertEquals(Arrays.asList(), result);
    }
}
