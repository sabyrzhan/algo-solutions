package kz.sabyrzhan.algo.leetcode.problems.p242;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramWordTest {
    AnagramWord test = new AnagramWord();

    @Test
    void test1() {
        var result = test.isAnagram("anagram", "nagaram");
        assertTrue(result);
    }

    @Test
    void test2() {
        var result = test.isAnagram("rat", "car");
        assertFalse(result);
    }
}