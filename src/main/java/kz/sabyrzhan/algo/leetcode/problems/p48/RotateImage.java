package kz.sabyrzhan.algo.leetcode.problems.p48;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution s = new Solution();
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        s.rotate(a);;
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[i].length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            System.out.println();
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
            System.out.println();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = tmp;
                }
            }
        }
    }
}
