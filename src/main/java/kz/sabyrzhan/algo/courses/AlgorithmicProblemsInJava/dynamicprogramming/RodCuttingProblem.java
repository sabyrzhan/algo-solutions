package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCuttingProblem {
    public static void main(String[] args) {
        RodCuttingProblem s = new RodCuttingProblem();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int[] sizes = {1,2,3,4};
        int[] prices = {2,5,7,3};
        int rodLength = 10;
        s.solve(sizes, prices, rodLength);
    }
    
    public class Solution {
        private int[] sizes;
        private int[] prices;
        private int rodLength;
        private int[][] table;

        public void solve(int[] sizes, int[] prices, int rodLength) {
            this.sizes = sizes;
            this.prices = prices;
            this.rodLength = rodLength;
            this.table = new int[sizes.length + 1][rodLength + 1];
            solve();
        }

        public void solve() {
            for(int i = 1; i <= sizes.length; i++) {
                for(int j = 1; j <= rodLength; j++) {
                    int value = 0;
                    if (sizes[i - 1] <= j) {
                        value = prices[i - 1] + table[i][j - sizes[i - 1]];
                    } else {
                        value = table[i - 1][j];
                    }

                    value = Math.max(table[i - 1][j], value);

                    table[i][j] = value;
                }
            }

            System.out.println(table[sizes.length][rodLength]);
            print();
            printValues();
        }

        private void printValues() {
            List<Integer> values = new ArrayList<>();
            for(int i = sizes.length, j = rodLength; i > 0;) {
                if (table[i][j] != 0 && table[i][j] != table[i - 1][j]) {
                    System.out.println("j = " + j + ", i = " + i);
                    values.add(sizes[i - 1]);
                    j = j - sizes[i - 1];
                } else {
                    i--;
                }
            }

            System.out.println(values);
        }

        private void print() {
            for(int i = 0; i < table.length; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        }
    }
}