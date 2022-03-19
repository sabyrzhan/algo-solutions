package kz.sabyrzhan.algo.leetcode.problems.p125;

public class ValidPalindrome {
    boolean isPalindrome(String s) {
        s = s.replaceAll("[\\W_]", "").toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
