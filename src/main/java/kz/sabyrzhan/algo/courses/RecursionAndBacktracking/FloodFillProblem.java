package kz.sabyrzhan.algo.courses.RecursionAndBacktracking;

public class FloodFillProblem {
    public static void main(String[] args) {
        FloodFillProblem s = new FloodFillProblem();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int[][] arr = {
                {0, 0, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0},

        };
        printArr(arr);
        s.fill(arr);
        System.out.println("Final:");
        printArr(arr);
    }

    private void printArr(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public class Solution {
        public void fill(int[][] arr) {
            for(int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == 1) {
                        fill(i, j, arr);
                        printArr(arr);
                    }
                }
            }
        }

        public void fill(int i, int j, int[][] arr) {
            if (i == arr.length || j == arr[0].length || i < 0 || j < 0 || arr[i][j] == 0) {
                return;
            }

            arr[i][j] = 0;
            fill(i + 1, j, arr);
            fill(i, j + 1, arr);
            fill(i - 1, j, arr);
            fill(i, j - 1, arr);
        }
    }
}
