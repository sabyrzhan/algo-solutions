package kz.sabyrzhan.algo.leetcode.problems.p50;

public class PowXN {
    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        PowXN p = new PowXN();
        Solution s = p.new Solution();
        System.out.println(s.myPow(x, n));
    }

    class Solution {
        public double myPow(double x, int n) {
            if (x == 0 && n != 0) {
                return 0;
            }

            if (n == 0) return 1;

            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }

            long count = 1;
            double product = x;
            while (count < N) {
                product *= product;
                count *= 2;
            }

            if (count == N) return product;
            long diff = count - N;
            return product / myPow(x, (int) diff);
        }
    }
}
