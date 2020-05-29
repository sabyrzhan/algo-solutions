package kz.sabyrzhan.algo.leetcode.Recursion1.CH3_Memoization;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs s = new ClimbingStairs();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int n = 3;
        System.out.println(s.climbStairs(n));;
    }

    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
