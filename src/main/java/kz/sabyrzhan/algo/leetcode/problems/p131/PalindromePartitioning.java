package kz.sabyrzhan.algo.leetcode.problems.p131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();

        String input = "aab";

        Solution s = p.new Solution();
        List<List<String>> result = s.partition(input);
        System.out.println(result);
    }

    class Solution {
        public List<List<String>> partition(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            for(int i = 0; i < s.length(); i++) {
                for(int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                    }
                }
            }

            List<List<String>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), dp, s, 0);
            return result;
        }

        private void helper(List<List<String>> result, List<String> items, boolean[][] dp, String s, int pos) {
            if (pos == s.length()) {
                result.add(new ArrayList<>(items));
                return;
            }

            for (int i = pos; i < s.length(); i++) {
                if (dp[pos][i]) {
                    items.add(s.substring(pos, i + 1));
                    helper(result, items, dp, s, i + 1);
                    items.remove(items.size() - 1);
                }
            }
        }
    }
}
