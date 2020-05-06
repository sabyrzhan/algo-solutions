package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.util.LinkedList;

public class NQueensProblem {
    public static void main(String[] args) {
        NQueensProblem s = new NQueensProblem();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        s.solve(4);
    }

    public class Solution {
        int i = 0;

        public void solve(int size) {
            solveImperative(size);
        }

        public void solveImperative(int size) {
            int[][] board = new int[size][size];

            LinkedList<int[]> positions = new LinkedList<>();
            for(int j = 0; j < board[0].length && i < board.length;) {
                if (isClashingImperative(i, j, board)) {
                    int[] prev = positions.pollLast();
                    while(prev != null && prev[0] + 1 >= board.length) {
                        board[prev[0]][prev[1]] = 0;
                        prev = positions.pollLast();
                    }
                    if (prev == null) {
                        break;
                    }
                    board[prev[0]][prev[1]] = 0;
                    i = prev[0] + 1;
                    j = prev[1];
                } else {
                    board[i][j] = 1;
                    positions.add(new int[]{i,j});
                    i = 0;
                    j++;
                }
            }
            print(board);
        }

        private boolean isClashingImperative(int row, int column, int[][] board) {
            if (row >= board.length) {
                return true;
            }

            boolean result = false;
            for(int i = 0; i < board[0].length; i++) {
                if(column != i && board[row][i] == 1) {
                    result = true;
                    break;
                }
            }

            for(int i = row, j = column; i < board.length && j >= 0; i++, j--) {
                if(i != row && column != j && board[i][j] == 1) {
                    result = true;
                    break;
                }
            }

            for(int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
                if(i != row && column != j && board[i][j] == 1) {
                    result = true;
                    break;
                }
            }

            if (result) {
                return isClashingImperative(row + 1, column, board);
            }

            i = row;

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
