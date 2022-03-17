package kz.sabyrzhan.algo.leetcode.problems.p50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowXNTest {
    PowXN pow = new PowXN();

    @Test
    void pow2_5() {
        double result = pow.myPow(2, 5);
        assertEquals(32, result);
    }

    @Test
    void pow2_min1() {
        double result = pow.myPow(2, -1);
        assertEquals(0.5, result);
    }

    @Test
    void pow2_min4() {
        double result = pow.myPow(2, -2);
        assertEquals(0.25, result);
    }

    @Test
    void pow3_2() {
        double result = pow.myPow(3, 2);
        assertEquals(9, result);
    }

    @Test
    void pow3_min3() {
        double result = pow.myPow(3, -3);
        assertEquals(1d/27, result);
    }

}