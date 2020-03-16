package kz.sabyrzhan.algo.leetcode.p54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        SpiralMatrix p = new SpiralMatrix();
        Solution s = p.new Solution();
        System.out.println(s.spiralOrder(input));
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> items = new ArrayList<>();
            if (matrix.length == 2 && matrix[0].length == 1) {
                items.add(matrix[0][0]);
                items.add(matrix[1][0]);
                return items;
            }

            if (matrix.length > 0) {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        items.add(matrix[i][j]);
                    }
                }

                int[][] tmpArray = rotate(matrix);
                items.addAll(spiralOrder(tmpArray));
            }

            return items;
        }

        private int[][] rotate(int[][] matrix) {
            int[][] tmp = new int[matrix[0].length][matrix.length - 1];
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                for (int i = 1; i < matrix.length; i++) {
                    tmp[matrix[0].length - 1 - j][i - 1] = matrix[i][j];
                }
            }

            return tmp;
        }
    }
}
