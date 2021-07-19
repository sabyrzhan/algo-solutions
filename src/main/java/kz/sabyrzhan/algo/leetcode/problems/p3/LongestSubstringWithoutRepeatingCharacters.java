package kz.sabyrzhan.algo.leetcode.problems.p3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, maxLen = 0;
        Map<Character, Integer> visited = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            len = 0;
            for (int j = i; j < s.length(); j++) {
                if (visited.get(s.charAt(j)) != null) {
                    break;
                }
                visited.put(s.charAt(j), 1);
                len++;
            }

            if (len > maxLen) {
                maxLen = len;
            }
            visited = new HashMap<>();
        }

        return maxLen;
    }
}
