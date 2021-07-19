package kz.sabyrzhan.algo.leetcode.problems.p7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    ReverseInteger rev = new ReverseInteger();

    @Test
    public void rev_success() {
        int num = 123;
        int result = rev.reverse(num);
        assertEquals(321, result);
    }

    @Test
    public void rev_success2() {
        int num = -123;
        int result = rev.reverse(num);
        assertEquals(-321, result);
    }

    @Test
    public void rev_success3() {
        int num = 120;
        int result = rev.reverse(num);
        assertEquals(21, result);
    }

    @Test
    public void rev_success4() {
        int num = 0;
        int result = rev.reverse(num);
        assertEquals(0, result);
    }
}
