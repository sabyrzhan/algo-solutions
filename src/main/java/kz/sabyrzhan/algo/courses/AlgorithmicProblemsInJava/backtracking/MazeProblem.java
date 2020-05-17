package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {
        MazeProblem s = new MazeProblem();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();

        int size = 5;
        int[][] maze = new int[][] {
                {0,0,0,0,0},
                {1,1,1,0,1},
                {0,0,1,0,0},
                {0,1,0,1,0},
                {1,0,0,0,0}
        };

        print(maze);
        System.out.println();
        s.solve(maze, size);
        print(maze);
    }
    
    public class Solution {
        private int[] xValues = {1,-1, 0, 0};
        private int[] yValues = {0, 0, 1, -1};

        public void solve(int[][] maze, int size) {
            boolean result = solveRecurseBacktrack(maze, size, 0, 0);
            System.out.println(result);
        }

        private boolean solveRecurseBacktrack(int[][] maze, int size, int x, int y) {
            if (x == size - 1 && y == size - 1) {
                maze[x][y] = 2;
                return true;
            }

            for(int i = 0; i < xValues.length; i++) {
                if (isValid(x, y, maze)) {
                    maze[x][y] = 2;
                    int nextX = xValues[i] + x;
                    int nextY = yValues[i] + y;
                    if (solveRecurseBacktrack(maze, size, nextX, nextY)) {
                        return true;
                    }
                    maze[x][y] = 0;
                }
            }

            return false;
        }

        private boolean isValid(int x, int y, int[][] maze) {
            if (x < 0 || y < 0 || x >= maze.length || y >= maze.length) {
                return false;
            }

            if (maze[x][y] != 0) {
                return false;
            }

            return true;
        }

        private void solveRecurse(int[][] maze, int size, int x, int y) {
            if (x >= size || y >= size || x < 0 || y < 0) {
                return;
            }

            if (maze[x][y] != 0) {
                return;
            }

            if (x == size - 1 && y == size - 1) {
                maze[x][y] = 2;
                return;
            }

            maze[x][y] = 2;

            solveRecurse(maze, size, x + 1, y);
            solveRecurse(maze, size, x, y + 1);
        }
    }

    private void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
