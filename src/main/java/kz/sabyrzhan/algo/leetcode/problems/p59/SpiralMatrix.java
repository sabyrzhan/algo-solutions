package kz.sabyrzhan.algo.leetcode.problems.p59;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int n = 5;
        SpiralMatrix p = new SpiralMatrix();
        Solution s = p.new Solution();
        int[][] merge = s.generateMatrix(n);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            if (n == 0) {
                return result;
            }

            int top = 0;
            int bottom = result.length - 1;
            int left = 0;
            int right = result[0].length - 1;
            int count = 1;
            int size = n * n;

            while (top <= bottom && left <= right && count <= size) {
                for (int i = left; i <= right; i++) {
                    result[top][i] = count++;
                }

                top++;

                for (int i = top; i <= bottom; i++) {
                    result[i][right] = count++;
                }
                right--;

                if (left <= bottom) {
                    for (int i = right; i >= left; i--) {
                        result[bottom][i] = count++;
                    }
                    bottom--;
                }

                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result[i][left] = count++;
                    }
                    left++;
                }
            }

            return result;
        }
    }
}
