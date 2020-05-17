package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {
    public static void main(String[] args) {
        KnapsackProblem s = new KnapsackProblem();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        int targetWeight = 5;
        int size = 3;
        int[] weights = new int[size];
        weights[0] = 4;
        weights[1] = 2;
        weights[2] = 3;

        int[] values = new int[size];
        values[0] = 10;
        values[1] = 4;
        values[2] = 7;

        s.solve(weights, values, targetWeight);
    }
    
    public class Solution {
        private int[] weights, values;
        private int targetWeight;
        private int[][] table;

        public void solve(int[] weights, int[] values, int targetWeight) {
            this.weights = new int[weights.length + 1];
            this.weights[0] = 0;
            for(int i = 0; i < weights.length; i++) {
                this.weights[i + 1] = weights[i];
            }
            this.values = new int[values.length + 1];
            this.values[0] = 0;
            for(int i = 0; i < values.length; i++) {
                this.values[i + 1] = values[i];
            }
            this.targetWeight = targetWeight;
            table = new int[this.values.length][targetWeight + 1];
            solve();
        }

        private void solve() {
            for(int i = 1; i < values.length; i++) {
                for(int j = 1; j <= targetWeight; j++) {
                    int sum = 0;
                    if (j - weights[i] >= 0) {
                        sum = values[i] + table[i - 1][j - weights[i]];
                    }

                    int max = Math.max(table[i - 1][j], sum);
                    table[i][j] = max;
                }
            }

            System.out.println(table[values.length - 1][targetWeight]);
            print();
            System.out.println(Arrays.toString(getSumValues()));
        }

        private int[] getSumValues() {
            List<Integer> result = new ArrayList<>();
            for(int i = values.length - 1, j = targetWeight; i > 0; i--) {
                if (table[i][j] != 0 && table[i][j] != table[i -1][j]) {
                    result.add(values[i]);
                    j = j - weights[i];
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private void print() {
            for(int i = 0; i < table.length; i++) {
                System.out.println(Arrays.toString(table[i]));
            }
        }
    }
}
