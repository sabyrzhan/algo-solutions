package kz.sabyrzhan.algo.courses.RecursionAndBacktracking;

public class FibonacciWithMemoization {
    public static void main(String[] args) {
        FibonacciWithMemoization s = new FibonacciWithMemoization();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        System.out.println(s.fib(5));
    }

    public class Solution {
        public int fib(int n) {
            return fibTabular(n);
        }

        private int fibTabular(int n) {
            int[] memo = new int[n + 2];
            memo[0] = 0;
            memo[1] = 1;
            for(int i = 2; i <= n + 1; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }

            return memo[n + 1];
        }

        private int fibWithMemo(int n, int[] memo) {
            if (n <= 1) {
                return 1;
            }

            if (memo[n] != 0) {
                return memo[n];
            }

            memo[n] = fibWithMemo(n - 1, memo) + fibWithMemo(n - 2, memo);
            return memo[n];
        }
    }
}
