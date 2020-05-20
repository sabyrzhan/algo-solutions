package kz.sabyrzhan.algo.courses.RecursionAndBacktracking;

public class MagnetChainProblem {
    public static void main(String[] args) {
        MagnetChainProblem s = new MagnetChainProblem();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int n = 3;
        s.solve(n);
    }

    public class Solution {

        private int n;
        int total = 0;
        private int[][] table;

        public void solve(int n) {
            this.n = n;
            this.table = new int[n][n];
            this.table[0][0] = 1;
            solveRecurse(1);
        }

        private boolean solveRecurse(int j ) {
            if (j > 0)
            if (j == n) {
                total++;
                return true;
            }

            for(int i = 0; i < n; i++) {
                if (solveRecurse(i + 1)) {
                    return false;
                }
            }

            return false;
        }
    }
}
