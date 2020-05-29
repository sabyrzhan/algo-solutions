package kz.sabyrzhan.algo.leetcode.Recursion1.CH4_ComplexityAnalysis;

public class PowerOfN {
    public static void main(String[] args) {
        PowerOfN s = new PowerOfN();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        System.out.println(s.myPow(2, -2));
    }

    public class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }

            if (x == 0) {
                return 0;
            }

            long N = n;
            if (n < 0) {
                x = 1 / x;
                N = -N;
            }

            long count = 1;
            double product = x;
            for(;count < N; count *= 2, product *= product);

            if (count == N) {
                return product;
            }

            long diff = count - N;
            return product / myPow(x, (int) diff);
        }
    }
}
