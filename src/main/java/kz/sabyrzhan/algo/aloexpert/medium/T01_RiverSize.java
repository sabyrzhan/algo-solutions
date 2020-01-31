package kz.sabyrzhan.algo.aloexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class T01_RiverSize {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,0,0,1,0, 1},
                {1,0,1,0,0, 1},
                {0,0,1,0,1, 1},
                {1,0,1,0,1, 1},
                {1,0,1,1,0, 1}
        };

        List<Integer> result = Program.riverSizes(matrix);
        System.out.println(result);
    }

    static class Program {
        public static List<Integer> riverSizes(int[][] matrix) {
            List<Integer> count = new ArrayList<>();
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    int element = matrix[i][j];
                    if(element == 1) {
                        printMatric(matrix);
                        int tmpCount = 0;
                        tmpCount += recurseCount(i, j, 1, matrix);
                        tmpCount += recurseCount(i, j + 1, 2, matrix);
                        tmpCount += recurseCount(i - 1, j, 3, matrix);
                        tmpCount += recurseCount(i + 1, j, 4, matrix);
                        if(tmpCount != 0) {
                            System.out.println("TmpCount: " + tmpCount + " i=" + i + ", j=" + j);
                            System.out.println();
                            count.add(tmpCount);
                        }
                    }
                }
            }

            return count;
        }

        private static int recurseCount(int i, int j, int direction, int[][] arr) {
            int tmp;
            switch (direction) {
                case 1:
                    if(j < 0 || arr[i][j] != 1) {
                        return 0;
                    }

                    arr[i][j] = 0;
                    tmp = 1 + recurseCount(i - 1, j, 3, arr)
                            + recurseCount(i + 1, j, 4, arr)
                            + recurseCount(i, j - 1, direction, arr);

                    return tmp;
                case 2:
                    if(j >= arr[0].length || arr[i][j] != 1) {
                        return 0;
                    }

                    arr[i][j] = 0;
                    tmp = 1 + recurseCount(i - 1, j, 3, arr)
                            + recurseCount(i + 1, j, 4, arr)
                            + recurseCount(i, j + 1, direction, arr);
                    return tmp;
                case 3:
                    if(i < 0 || arr[i][j] != 1) {
                        return 0;
                    }
                    arr[i][j] = 0;
                    tmp = 1 + recurseCount(i, j - 1, 1, arr)
                            + recurseCount(i, j + 1, 2, arr)
                            + recurseCount(i - 1, j, direction, arr);
                    return tmp;
                case 4:
                    if(i >= arr.length || arr[i][j] != 1) {
                        return 0;
                    }
                    arr[i][j] = 0;
                    tmp = 1 + recurseCount(i, j - 1, 1, arr)
                            + recurseCount(i, j + 1, 2, arr)
                            + recurseCount(i + 1, j, direction, arr);
                    return tmp;
                default:
                    return 0;
            }
        }
    }


    private static void printMatric(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
