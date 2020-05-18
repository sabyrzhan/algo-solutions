package kz.sabyrzhan.algo.leetcode.Recursion1.CH3_Memoization;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs s = new ClimbingStairs();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int n = 3;
        System.out.println(s.climbStairs(n));
    }

    class Solution {
        public int climbStairs(int n) {
            int[][] steps = new int[n + 1][n + 1];
            return 0;
        }
    }
}
