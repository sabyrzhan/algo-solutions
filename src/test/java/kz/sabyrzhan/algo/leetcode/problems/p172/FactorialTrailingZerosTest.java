package kz.sabyrzhan.algo.leetcode.problems.p172;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTrailingZerosTest {
    FactorialTrailingZeros trailingZeros = new FactorialTrailingZeros();
    @Test
    void countFor5() {
        int n = 5;
        int result = trailingZeros.countTrailingZeros(n);
        assertEquals(1, result);
    }

    @Test
    void countFor1() {
        int n = 1;
        int result = trailingZeros.countTrailingZeros(n);
        assertEquals(0, result);
    }

    @Test
    void countFor10() {
        int n = 10;
        int result = trailingZeros.countTrailingZeros(n);
        assertEquals(2, result);
    }

    @Test
    void countFor11() {
        int n = 11;
        int result = trailingZeros.countTrailingZeros(n);
        assertEquals(2, result);
    }
}