package kz.sabyrzhan.algo.leetcode.problems.p74;

import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix p = new Search2DMatrix();

        int[][] input = new int[][] {
                {1},
                {3},
        };

        int target = 3;

        Solution s = p.new Solution();
        boolean found = s.searchMatrix(input, target);
        System.out.println(found);
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int[] row = new int[0];

            if (target <= matrix[0][matrix[0].length - 1]) {
                row = matrix[0];
            } else {
                for(int i = 1; i < matrix.length; i++) {
                    if (target < matrix[i][0]) {
                        row = matrix[i - 1];
                        break;
                    }
                }
            }

            if (row.length == 0) {
                if (target <= matrix[matrix.length - 1][matrix[0].length - 1]) {
                    row = matrix[matrix.length - 1];
                }
            }

            Arrays.sort(row);
            int value = Arrays.binarySearch(row, target);
            return value >= 0;
        }
    }
}
