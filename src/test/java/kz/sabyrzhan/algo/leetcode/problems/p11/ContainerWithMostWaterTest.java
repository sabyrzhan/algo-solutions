package kz.sabyrzhan.algo.leetcode.problems.p11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {
    ContainerWithMostWater area = new ContainerWithMostWater();

    @Test
    public void maxArea_success() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = area.maxArea(height);
        assertEquals(49, result);
    }

    @Test
    public void maxArea_success2() {
        int[] height = {1,1};
        int result = area.maxArea(height);
        assertEquals(1, result);
    }

    @Test
    public void maxArea_success3() {
        int[] height = {4,3,2,1,4};
        int result = area.maxArea(height);
        assertEquals(16, result);
    }

    @Test
    public void maxArea_success4() {
        int[] height = {1,2,1};
        int result = area.maxArea(height);
        assertEquals(2, result);
    }
}