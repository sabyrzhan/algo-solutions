package kz.sabyrzhan.algo.leetcode.p29;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers tw = new DivideTwoIntegers();
        Solution s = tw.new Solution();
        int result = s.divide(Integer.MIN_VALUE, -1);
        System.out.println(20 << 1 << 1);
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if(divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) {
                return 1;
            }

            if(divisor == Integer.MIN_VALUE) {
                return 0;
            }

            if(dividend == 0) {
                return 0;
            }

            if(divisor == 1) {
                return dividend;
            }

            if(divisor == -1) {
                if(dividend == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return 0 - dividend;
                }
            }

            int absDivisor = Math.abs(divisor);
            int result;
            int count = 0;

            if(dividend < 0) {
                if(dividend == Integer.MIN_VALUE) {
                    result = dividend + absDivisor;
                    count = subtractOrAdd(dividend, divisor, count);
                } else {
                    result = dividend;
                }

                while(Math.abs(result) >= absDivisor) {
                    result = result + absDivisor;
                    if(result == Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    count = subtractOrAdd(dividend, divisor, count);
                }
            } else {
                result = dividend;
                while(result >= absDivisor) {
                    result = result - absDivisor;
                    count = subtractOrAdd(dividend, divisor, count);
                }
            }

            if(dividend < 0 && divisor < 0) {
                return count == Integer.MIN_VALUE ? Integer.MAX_VALUE : count;
            } else {
                return count;
            }
        }

        /*
        The subtract method is needed, because c+=-1 or c+=1 operators are time consuming.
        It is better to subtract explicitly.
         */
        private int subtractOrAdd(int dividend, int divisor, int count) {
            if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
                return count - 1;
            } else {
                return count + 1;
            }
        }
    }
}
