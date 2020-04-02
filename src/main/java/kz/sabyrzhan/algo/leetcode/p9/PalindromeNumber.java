package kz.sabyrzhan.algo.leetcode.p9;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();

        int input = 121;

        Solution solution = p.new Solution();
        System.out.println(solution.isPalindrome(input));
    }

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int original = x;
            int result = 0;
            while(x != 0) {
                int remain = x % 10;
                result = result * 10 + remain;
                x /= 10;
            }

            return result == original;
        }
    }
}