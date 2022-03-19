package kz.sabyrzhan.algo.leetcode.problems.p151;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInAStringTest {
    ReverseWordsInAString rev = new ReverseWordsInAString();

    @Test
    void test1() {
        String s = "   ";
        String result = rev.reverseWords(s);
        assertEquals("", result);
    }

    @Test
    void test2() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        assertEquals(expected, rev.reverseWords(s));
    }

    @Test
    void test3() {
        String s = "  hello world  ";
        String expected = "world hello";
        assertEquals(expected, rev.reverseWords(s));
    }

    @Test
    void test4() {
        String s = "a good   example";
        String expected = "example good a";
        assertEquals(expected,rev.reverseWords(s));
    }
}