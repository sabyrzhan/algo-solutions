package kz.sabyrzhan.algo.leetcode.Recursion1.CH2_RecurrenceRelation;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static void main(String[] args) {
        PascalsTriangle2 s = new PascalsTriangle2();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        List<Integer> result = s.getRow(3);
        System.out.println(result);
    }

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            if(rowIndex <= 1) {
                result.add(1);
                if(rowIndex == 1) {
                    result.add(1);
                }

                return result;
            }

            int[][] grid = new int[rowIndex + 1][rowIndex + 1];
            grid[0][0] = 1;
            grid[1][0] = 1;
            grid[1][1] = 1;

            getRowRecurse(grid,2,rowIndex, result);

            return result;
        }

        private void getRowRecurse(int[][] grid, int i, int rowIndex, List<Integer> result) {
            if(i == rowIndex + 1) {
                for(int j = 0; j < rowIndex + 1; j++) {
                    result.add(grid[i - 1][j]);
                }

                return;
            }

            grid[i][0] = 1;
            grid[i][rowIndex] = 1;
            for(int j = 1; j < rowIndex; j++) {
                grid[i][j] = grid[i - 1][j - 1] + grid[i - 1][j];
            }

            getRowRecurse(grid, i + 1, rowIndex, result);
        }


        public List<Integer> getRowImperative(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            if(rowIndex == 0) {
                result.add(1);
                return result;
            }

            if(rowIndex == 1) {
                result.add(1);
                result.add(1);
                return result;
            }

            int[][] grid = new int[rowIndex + 1][rowIndex + 1];
            grid[0][0] = 1;
            grid[1][0] = 1;
            grid[1][1] = 1;

            for(int i = 2; i <= rowIndex; i++) {
                List<Integer> row = new ArrayList<>();
                int j = 0;
                grid[i][j++]=1;
                grid[i][i] = 1;
                for(j = 1; j < i; j++) {
                    grid[i][j] = grid[i - 1][j - 1] + grid[i - 1][j];
                    row.add(grid[i][j]);
                }

                if (i == rowIndex) {
                    for(j = 0; j < i + 1; j++) {
                        result.add(grid[i][j]);
                    }
                }
            }

            return result;
        }
    }
}
