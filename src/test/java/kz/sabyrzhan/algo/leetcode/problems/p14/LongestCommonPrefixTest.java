package kz.sabyrzhan.algo.leetcode.problems.p14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    LongestCommonPrefix lon = new LongestCommonPrefix();

    @Test
    void long_success() {
        String[] strs = {"flower","flow","flight"};
        String s = lon.longestCommonPrefix(strs);
        assertEquals("fl", s);
    }

    @Test
    void long_success2() {
        String[] strs = {"dog","racecar","car"};
        String s = lon.longestCommonPrefix(strs);
        assertEquals("", s);
    }

    @Test
    void long_success3() {
        String[] strs = {"flaaaaaa","flo","flight"};
        String s = lon.longestCommonPrefix(strs);
        assertEquals("fl", s);
    }

    @Test
    void long_success4() {
        String[] strs = {"flaaaaaa","flo","goal"};
        String s = lon.longestCommonPrefix(strs);
        assertEquals("", s);
    }
}
