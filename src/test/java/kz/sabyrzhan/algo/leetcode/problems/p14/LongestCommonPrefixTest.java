package kz.sabyrzhan.algo.leetcode.problems.p14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    LongestCommonPrefix lon = new LongestCommonPrefix();

    @Test
    public void long_success() {
        String[] strs = {"flower","flow","flight"};
        String s = lon.longestCommonPrefix(strs);
        assertEquals("fl", s);
    }

    @Test
    public void long_success2() {
        String[] strs = {"dog","racecar","car"};
        String s = lon.longestCommonPrefix(strs);
        assertEquals("", s);
    }
}
