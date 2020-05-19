package kz.sabyrzhan.algo.leetcode.Recursion1.CH3_Memoization;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs s = new ClimbingStairs();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int n = 2;
        System.out.println(s.climbStairs(n));;
    }

    class Solution {
        private int[] steps = {1,2};
        private int n;
        private int[][] table;

        public int climbStairs(int n) {
            this.n = n;
            this.table = new int[steps.length + 1][n + 1];
            int result = climbStairs();
            print();
            return result;
        }

        public int climbStairs() {
            for(int i = 1; i <= steps.length; i++) {
                for(int j = 1; j <= n; j++) {
                    if (steps[i - 1] <= j) {
                        table[i][j] = table[i - 1][j] + table[i][j - steps[i - 1]];
                    } else {
                        table[i][j] = table[i - 1][j];
                    }
                }
            }

            return table[steps.length][n];
        }

        private void print() {
            for(int i = 0; i < table.length; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        }
    }
}
