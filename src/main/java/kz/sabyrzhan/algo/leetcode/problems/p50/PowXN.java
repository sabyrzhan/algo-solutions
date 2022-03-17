package kz.sabyrzhan.algo.leetcode.problems.p50;

public class PowXN {
    public double myPow(double x, int n) {
        int nn = Math.abs(n);
        double ans = 1;
        while(nn > 0) {
            if (nn % 2 == 0) {
                x *= x;
                nn /= 2;
            } else {
                ans *= x;
                nn -= 1;
            }
        }

        if (n < 0) {
            ans = 1d / ans;
        }

        return ans;
    }
}
