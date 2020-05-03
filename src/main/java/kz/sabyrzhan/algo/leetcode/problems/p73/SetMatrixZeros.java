package kz.sabyrzhan.algo.leetcode.problems.p73;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        SetMatrixZeros p = new SetMatrixZeros();

        int[][] input = new int[][] {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        Solution s = p.new Solution();
        s.setZeroes(input);
        for(int[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean col = false, row = false;
            int n = matrix.length;
            int m = matrix[0].length;

            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                        if (i == 0) row = true;
                        if (j == 0) col = true;
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < m; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < n; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (row) {
                for(int i = 0; i < m; i++) {
                    matrix[0][i] = 0;
                }
            }

            if (col) {
                for(int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
