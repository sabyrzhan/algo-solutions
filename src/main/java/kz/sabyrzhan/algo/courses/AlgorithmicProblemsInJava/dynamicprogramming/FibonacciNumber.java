package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.dynamicprogramming;

public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber s = new FibonacciNumber();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();
        long result = s.solve(1000);
        System.out.println(result);
    }
    
    public class Solution {
        public long solve(int n) {
            long[] arr = new long[n + 1];
            arr[0] = 0;
            arr[1] = 1;
            for(int i = 2; i < n + 1; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }

            return arr[n];
        }
    }
}
