package kz.sabyrzhan.algo.leetcode.problems.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters runner = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void substr_success() {
        String str = "abcabcbb";
        int result = runner.lengthOfLongestSubstring(str);
        assertEquals(3, result);
    }

    @Test
    public void substr_success2() {
        String str = "bbbbb";
        int result = runner.lengthOfLongestSubstring(str);
        assertEquals(1, result);
    }

    @Test
    public void substr_success3() {
        String str = "pwwkew";
        int result = runner.lengthOfLongestSubstring(str);
        assertEquals(3, result);
    }

    @Test
    public void substr_success4() {
        String str = "abcdef";
        int result = runner.lengthOfLongestSubstring(str);
        assertEquals(6, result);
    }
}
