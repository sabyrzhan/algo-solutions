package kz.sabyrzhan.algo.leetcode.problems.p91;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays p = new DecodeWays();

        String n = "2622626";

        Solution s = p.new Solution();
        int result = s.numDecodings(n);
        System.out.println(result);
    }

    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;

            for(int i = 2; i <= s.length(); i++) {
                int first = Integer.valueOf(s.substring(i - 1, i));
                int second = Integer.valueOf(s.substring(i - 2, i));
                System.out.println(first + " : " + second);

                if (first >= 1 && first <= 9) {
                    dp[i] += dp[i - 1];
                }

                if (second >= 10 && second <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            System.out.println(Arrays.toString(dp));

            return dp[s.length()];
        }
    }
}
