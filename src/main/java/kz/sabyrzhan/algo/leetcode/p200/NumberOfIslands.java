package kz.sabyrzhan.algo.leetcode.p200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands p = new NumberOfIslands();

       char[][] input = new char[][] {
               {'1', '1', '1', '1', '0'},
               {'1', '1', '0', '1', '0'},
               {'1', '1', '0', '0', '0'},
               {'0', '0', '0', '0', '0'},
       };

        Solution s = p.new Solution();
        int result = s.numIslands(input);
        System.out.println(result);
    }

    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1') {
                        dfs(i, j, grid);
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfs(int i, int j, char[][] grid) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
                return;
            }

            grid[i][j] = 0;
            dfs(i + 1, j, grid);
            dfs(i - 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i, j - 1, grid);
        }
    }
}
