package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

public class SudokuProblem {
    public static void main(String[] args) {
        SudokuProblem s = new SudokuProblem();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        
    }
    
    public class Solution {
        private int[] filledTables = {0,0,0,0,0,0,0,0,0};
        private int[][] table;

        public void solve(int[][] table) {
            this.table = table;
        }

        public void solveRecurse(int[][] table, int x, int y) {

        }

        private int subtableIndex(int x, int y) {
            int subTableX = 9 / x;
            int subTableY = 9 / y;

        }
    }
}
