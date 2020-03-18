package kz.sabyrzhan.algo.leetcode.p64;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum p = new MinimumPathSum();

        int[][] arr = new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        Solution s = p.new Solution();
        int res = s.minPathSum(arr);
        System.out.println(res);
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            return helper(grid, 0, 0, new int[grid.length][grid[0].length]);
        }

        public int helper(int[][] grid, int i, int j, int[][] mem) {
            if (i >= grid.length || j >= grid[0].length) {
                return Integer.MAX_VALUE;
            }

            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return grid[i][j];
            }

            if (mem[i][j] != 0) {
                return mem[i][j];
            }

            int min = grid[i][j];
            min += Math.min(helper(grid, i + 1, j, mem), helper(grid, i, j + 1, mem));
            mem[i][j] = min;

            return min;
        }
    }
}
