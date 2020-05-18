package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {
        CoinChangeProblem s = new CoinChangeProblem();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int[] coins = new int[] { 1,2,3 };
        int M = 4;

        s.solve(coins, M);
    }
    
    public class Solution {
        private int[] coins;
        private int targetAmount;
        private int[][] table;

        public void solve(int[] coins, int M) {
            this.coins = coins;
            this.targetAmount = M;
            this.table = new int[coins.length + 1][M + 1];
            for(int i = 0; i < table.length; i++) {
                table[i][0] = 1;
            }
            solve();
        }

        private void solve() {
            for(int i = 1; i <= coins.length; i++) {
                for(int j = 1; j <= targetAmount; j++) {
                    int value;
                    if (coins[i - 1] <= j) {
                        value = table[i - 1][j] + table[i][j - coins[i - 1]];
                    } else {
                        value = table[i - 1][j];
                    }
                    table[i][j] = value;
                }
            }

            print();
            System.out.println(table[coins.length][targetAmount]);
        }

        private void print() {
            for(int i = 0; i < table.length; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        }
    }
}
