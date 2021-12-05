package kz.sabyrzhan.algo.aloexpert.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class T01_TwoSumTest {
    private T01_TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new T01_TwoSum();
    }

    @Test
    public void test1() {
        int[] result = twoSum.twoNumberSum(new int[] {3,5,-4,8,11,1,-1,6}, 10);
        assertArrayEquals(new int[] {11,-1}, result);
    }
}