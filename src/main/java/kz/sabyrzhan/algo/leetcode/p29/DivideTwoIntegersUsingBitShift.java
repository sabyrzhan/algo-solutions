package kz.sabyrzhan.algo.leetcode.p29;
/*
    Solution as was explained at https://www.youtube.com/watch?v=htX69j1jf5U
 */
public class DivideTwoIntegersUsingBitShift {
    public static void main(String[] args) {
        DivideTwoIntegersUsingBitShift tw = new DivideTwoIntegersUsingBitShift();
        Solution s = tw.new Solution();
        int result = s.divide(5, -2);
        System.out.println(result);
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            int a = Math.abs(dividend);
            int b = Math.abs(divisor);
            int result = 0;
            while(a - b >= 0) {
                int x = 0;
                while(a - (b << 1 << x) >= 0) {
                    x++;
                }
                result += 1 << x;
                a -= b << x;
            }

            return (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0) ? result : -result;
        }
    }
}
