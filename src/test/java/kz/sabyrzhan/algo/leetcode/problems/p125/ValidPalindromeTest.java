package kz.sabyrzhan.algo.leetcode.problems.p125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {
    ValidPalindrome pal = new ValidPalindrome();

    @Test
    void test1() {
        assertTrue(pal.isPalindrome(" , "));
    }

    @Test
    void test2() {
        assertTrue(pal.isPalindrome(","));
    }

    @Test
    void test3() {
        assertTrue(pal.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void test4() {
        assertFalse(pal.isPalindrome("race a car"));
    }
}