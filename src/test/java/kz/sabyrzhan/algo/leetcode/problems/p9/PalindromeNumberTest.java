package kz.sabyrzhan.algo.leetcode.problems.p9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {
    PalindromeNumber pn = new PalindromeNumber();


    @Test
    public void isPn_success() {
        int x = 121;
        boolean result = pn.isPalindrome(x);
        assertTrue(result);
    }

    @Test
    public void isPn_success2() {
        int x = -121;
        boolean result = pn.isPalindrome(x);
        assertFalse(result);
    }

    @Test
    public void isPn_success3() {
        int x = 10;
        boolean result = pn.isPalindrome(x);
        assertFalse(result);
    }

    @Test
    public void isPn_success4() {
        int x = -101;
        boolean result = pn.isPalindrome(x);
        assertFalse(result);
    }
}
