package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum s = new SubsetSum();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int[] set = {5,2,1,3};
        int sum = 6;
        s.solve(set, sum);
    }
    
    public class Solution {
        private int[] set;
        private int sum;
        private boolean[][] table;

        private void solve(int[] set, int sum) {
            this.set = set;
            this.sum = sum;
            this.table = new boolean[set.length + 1][sum + 1];
            for(int i = 0; i < table.length; i++) {
                table[i][0] = true;
            }
            solve();
        }

        private void solve() {
            for(int i = 1; i <= set.length; i++) {
                for(int j = 1; j <= sum; j++) {
                    boolean value;
                    if (table[i - 1][j]) {
                        value = true;
                    } else {
                        if (set[i - 1] <= j) {
                            value = table[i - 1][j - set[i - 1]];
                        } else {
                            value = false;
                        }
                    }
                    table[i][j] = value;
                }
            }

            print();
            printArr();
        }

        private void printArr() {
            for(int i = 0; i < table.length; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        }

        private void print() {
            List<Integer> values = new ArrayList<>();
            for(int i = set.length, j = sum; i > 0; i--) {
                if (table[i][j] && !table[i - 1][j]) {
                    values.add(set[i - 1]);
                    j = j - set[i - 1];
                }
            }

            System.out.println(values);
        }
    }
}
