package kz.sabyrzhan.algo.leetcode.p7;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger p = new ReverseInteger();

        int input = -123;

        Solution solution = p.new Solution();
        System.out.println(solution.reverse(input));
    }

    class Solution {
        public int reverse(int x) {
            int result = 0;
            while( x != 0) {
                int remain = x % 10;
                int result2 = result * 10 + remain;
                if ((result2 - remain) / 10 != result) {
                    return 0;
                }
                result = result2;
                x /= 10;
            }

            return result;
        }
    }
}