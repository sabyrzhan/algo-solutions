package kz.sabyrzhan.algo.leetcode.Recursion2.CH1_DivideAndConquer;

public class Search2DMatrix2 {
    public static void main(String[] args) {
        Search2DMatrix2 s = new Search2DMatrix2();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int[][] values = {
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}
        };

        int target = -5;

        boolean b = s.searchMatrix(values, target);
        System.out.println(b);
    }

    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for(int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                if (row.length == 0) {
                    continue;
                }

                if(target < row[0] || target >row[row.length - 1]) {
                    continue;
                }

                boolean isFound = searchBinary(row, 0, row.length - 1, target);
                if(isFound) {
                    return true;
                }
            }

            return false;
        }

        private boolean searchBinary(int[] row, int left, int right, int target) {
            if (left == right) {
                if(row[left] == target) {
                    return true;
                }
            }

            if (left < right) {
                int mid = left + (right - left)/2;
                if (row[mid] == target) {
                    return true;
                }

                if (row[mid] > target) {
                    return searchBinary(row, left, mid, target);
                } else {
                    return searchBinary(row, mid + 1, right, target);
                }
            }

            return false;
        }
    }
}
