package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class KnightsTour {
    public static void main(String[] args) {
        KnightsTour s = new KnightsTour();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int size = 5;
        int[][] board = new int[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.MIN_VALUE;
            }
        }
        s.solve(board);
    }

    public class Solution {
        private PrintWriter fos;

        private int[] xValues = {1, -1, 1, -1, 2, 2, -2, -2};
        private int[] yValues = {2, 2, -2, -2, 1, -1, 1, -1};

        public boolean solve(int[][] board) {
            try {
                fos = new PrintWriter(new File("/Users/stynybayev/projects/algo-solutions/aaa.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            boolean result = solveRecurse(2,2, board, 1);
            System.out.println(result);
            print(board);
            fos.close();

            return result;
        }

        private void print(int[][] arr) {
            for(int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
        }

        private void write(int[][] arr) {
            for(int i = 0; i < arr.length; i++) {
                fos.println(Arrays.toString(arr[i]));
            }
            fos.println();
        }

        private boolean solveRecurseBacktrack(int x, int y, int[][] board, int inc) {
            if (inc == board.length * board.length + 1) {
                return true;
            }

            for(int i = 0; i < xValues.length; i++) {
                if (isValid(x,y, board)) {
                    board[x][y] = inc;
                    int nextX = xValues[i] + x;
                    int nextY = yValues[i] + y;
                    if (solveRecurse(nextX, nextY, board, inc + 1)) {
                        return true;
                    }
                    board[x][y] = Integer.MIN_VALUE;
                }
            }

            return false;
        }

        private boolean solveRecurse(int x, int y, int[][] board, int inc) {
            if (!isValid(x, y, board)) {
                return false;
            }

            board[x][y] = inc;
            for(int i = 0; i < xValues.length; i++) {
                int nextX = xValues[i] + x;
                int nextY = yValues[i] + y;
                solveRecurse(nextX, nextY, board, inc + 1);
            }

            return true;
        }

        private boolean isValid(int x, int y, int[][] board) {
            if (x >= board.length || y >= board.length || x < 0 || y < 0) {
                return false;
            }

            if (board[x][y] != Integer.MIN_VALUE) {
                return false;
            }

            return true;
        }
    }
}
