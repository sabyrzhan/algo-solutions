package kz.sabyrzhan.algo.leetcode.problems.p14;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Time complexity: O(log(n))
        Arrays.sort(strs);
        StringBuilder s = new StringBuilder();
        // Time complexity: O(n)
        for(int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            s.append(strs[0].charAt(i));
        }

        // Total time complexity: O(nlogn) + O(n) = o(nlogn)
        return s.toString();
    }
}
