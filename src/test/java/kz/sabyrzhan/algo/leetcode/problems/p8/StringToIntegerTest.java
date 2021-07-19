package kz.sabyrzhan.algo.leetcode.problems.p8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {
    StringToInteger str = new StringToInteger();

    @Test
    public void atoi_success() {
        String s = "42";
        int result = str.myAtoi(s);
        assertEquals(42, result);
    }

    @Test
    public void atoi_success2() {
        String s = "   -42";
        int result = str.myAtoi(s);
        assertEquals(-42, result);
    }

    @Test
    public void atoi_success3() {
        String s = "4193 with words";
        int result = str.myAtoi(s);
        assertEquals(4193, result);
    }

    @Test
    public void atoi_success4() {
        String s = "words and 987";
        int result = str.myAtoi(s);
        assertEquals(987, result);
    }

    @Test
    public void atoi_success5() {
        String s = "-91283472332";
        int result = str.myAtoi(s);
        assertEquals(-2147483648, result);
    }

    @Test
    public void atoi_success6() {
        String s = "some words";
        int result = str.myAtoi(s);
        assertEquals(0, result);
    }
}
