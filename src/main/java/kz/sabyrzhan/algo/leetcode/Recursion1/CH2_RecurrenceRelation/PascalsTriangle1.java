package kz.sabyrzhan.algo.leetcode.Recursion1.CH2_RecurrenceRelation;

public class PascalsTriangle1 {
    public static void main(String[] args) {
        PascalsTriangle1 s = new PascalsTriangle1();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int row = 4;
        int column = 2;
        System.out.println(s.findValue(row, column));
    }

    public class Solution {
        public int findValue(int row, int column) {
            int[][] grid = new int[row + 1][row + 1];
            grid[0][0] = 1;
            grid[1][0] = 1;
            grid[1][1] = 1;
            int result = findValueRecurse(row, column, grid);
            print(grid);
            return result;
        }

        private void print(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }

        public int findValueRecurse(int row, int column, int[][] grid) {
            if(row <= 1) {
                return 1;
            }

            if(column == 0 || column == row) {
                grid[row][column] = 1;
            }

            int a = findValueRecurse(row - 1, column - 1, grid);
            int b = findValueRecurse(row - 1, column, grid);
            if (column  > 0 && column < row) {
                grid[row][column] = a + b;
                System.out.println("a=" + a + ", b=" + b + ", r=" +(a+b)+ ", i=" + row + ",j=" + column);
            }

            return grid[row][column];
        }
    }
}