package kz.sabyrzhan.algo.leetcode.p139;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak p = new WordBreak();

        String input = "aaaaaaa";
        List<String> dict = Arrays.asList("aaaa", "aaa");

        Solution s = p.new Solution();
        boolean result = s.wordBreak(input, dict);
        System.out.println(result);
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for(int i = 1; i <= s.length(); i++) {
                for(int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
