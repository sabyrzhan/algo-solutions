package kz.sabyrzhan.algo.leetcode.problems.p394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {
    DecodeString dec = new DecodeString();

    @Test
    void test1() {
        String result = dec.decodeString("3[a]2[bc]");
        assertEquals("aaabcbc", result);
    }

    @Test
    void test2() {
        String result = dec.decodeString("3[a2[c]]");
        assertEquals("accaccacc", result);
    }

    @Test
    void test3() {
        String result = dec.decodeString("2[abc]3[cd]ef");
        assertEquals("abcabccdcdcdef", result);
    }

    @Test
    void test4() {
        String result = dec.decodeString("10[ab]");
        assertEquals("abababababababababab", result);
    }
}