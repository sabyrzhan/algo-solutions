package kz.sabyrzhan.algo.leetcode.problems.p14;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s = "";
        for(int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            s += strs[0].charAt(i);
        }

        return s;
    }
}
