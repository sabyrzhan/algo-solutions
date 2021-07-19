package kz.sabyrzhan.algo.leetcode.problems.p7;

public class ReverseInteger {
    public int reverse(int x) {
        long xx = x;
        xx = xx * (x < 0 ? -1 : 1);
        String rev = new StringBuilder("" + xx).reverse().toString();
        long num = Long.parseLong(rev) * (x < 0 ? -1 : 1);
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) num;
        }
    }
}
