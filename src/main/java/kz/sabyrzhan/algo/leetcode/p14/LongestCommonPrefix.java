package kz.sabyrzhan.algo.leetcode.p14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix p = new LongestCommonPrefix();

        String[] input = new String[] {"flower","flow","flight"};

        Solution solution = p.new Solution();
        System.out.println(solution.longestCommonPrefix(input));
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length < 1) return "";
            Arrays.sort(strs);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < strs[0].length(); i++) {
                if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                    break;
                }

                sb.append(strs[0].charAt(i));
            }

            return sb.toString();
        }
    }
}