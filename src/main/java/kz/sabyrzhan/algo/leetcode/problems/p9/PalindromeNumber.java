package kz.sabyrzhan.algo.leetcode.problems.p9;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return Long.parseLong(new StringBuilder().append(x).reverse().toString()) == x;
    }
}
