package kz.sabyrzhan.algo.leetcode.problems.p10;

// https://www.youtube.com/watch?v=l3hda49XcDE
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching p = new RegularExpressionMatching();

        String s = "aaa";
        String pat = "ab*ac*a";

        Solution solution = p.new Solution();
        System.out.println(solution.isMatch(s, pat));
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

            dp[0][0] = true;
            for(int i = 1; i < dp[0].length; i++) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }

            for(int i = 1; i < dp.length; i++) {
                for(int j = 1; j < dp[0].length; j++) {
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                        if (j - 2 >= 0 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
                            dp[i][j] = dp[i][j] | dp[i - 1][j];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
}