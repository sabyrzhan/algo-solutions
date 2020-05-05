package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.util.LinkedList;

public class NQueensProblem {
    public static void main(String[] args) {
        NQueensProblem s = new NQueensProblem();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        s.solve(5);
    }

    public class Solution {
        public void solve(int size) {
            int[][] board = new int[size][size];

            int i = 0;
            int j = 0;
            LinkedList<int[]> positions = new LinkedList<>();
            while(j < board[0].length) {
                while(i < board.length) {
                    print(board);
                    if(isClashing(j, i, board)) {
                        int[] last = positions.pollLast();
                        i = last[0] + 1;
                        j = last[1] - 1;
                        board[last[0]][last[1]] = 0;
                        System.out.println("Printing clash: ");
                        print(board);
                        break;
                    }

                    board[i][j] = 1;
                    positions.add(new int[]{i,j});
                    break;
                }
                j++;
            }
            //solveRecurs(1, 0, board);
            print(board);
        }

        public void solveRecurs(int row, int column, int[][] board) {
            if (row >= board.length || column >= board[0].length) {
                return;
            }
            if(isClashing(row,column, board)) {
                board[row][column] = 0;
                return;
            }

            for(int i = 0; i < board.length; i++) {
                board[row][column] = 1;
                solveRecurs(row+1, column, board);
            }
        }

        private boolean isClashing(int row, int column, int[][] board) {
            for(int i = 0; i < board[0].length; i++) {
                if(column != i && board[row][i] == 1) {
                    return true;
                }
            }

            for(int i = row; i < board.length; i++) {
                for (int j = column; j >= 0; j--) {
                    if(i != row && column != j && board[i][j] == 1) {
                        return true;
                    }
                }
            }

            for(int i = row; i >= 0; i--) {
                for (int j = column; j >= 0; j--) {
                    if(i != row && column != j && board[i][j] == 1) {
                        return true;
                    }
                }
            }

            return false;
        }

        public void print(int[][] board) {
            System.out.println();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
