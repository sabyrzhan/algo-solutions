package kz.sabyrzhan.algo.leetcode.problems.p3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters p = new LongestSubstringWithoutRepeatingCharacters();

        String input = "abcabcbb";

        Solution solution = p.new Solution();
        System.out.println(solution.lengthOfLongestSubstring(input));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int dupIndex = 0;
            Map<Character, Integer> chars = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (chars.containsKey(c)) {
                    dupIndex = Math.max(dupIndex, chars.get(c) + 1);
                }

                chars.put(c, i);
                max = Math.max(max, i - dupIndex + 1);
            }

            return max;
        }
    }
}