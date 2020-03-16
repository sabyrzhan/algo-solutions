package kz.sabyrzhan.algo.leetcode.p43;

import java.util.Arrays;

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        Solution s = m.new Solution();
        String result = s.multiply("123", "456");
        System.out.println(result);
    }

    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int len1 = num1.length();
            int len2 = num2.length();

            int[] result = new int[len1 + len2];

            char[] char1 = num1.toCharArray();
            char[] char2 = num2.toCharArray();

            int k = 1;

            for (int i = len2 - 1; i >= 0; i--) {
                int index = result.length - k;
                int carry = 0;
                int sumCarry = 0;

                int a = intValue(char2[i]);

                for (int j = len1 - 1; j >= 0; j--) {
                    int b = intValue(char1[j]);
                    int res = a * b;
                    result[index] += (res % 10) + carry + sumCarry;
                    carry = res / 10;
                    sumCarry = result[index] / 10;
                    result[index--] %= 10;
                }

                if (carry > 0) {
                    result[index] += carry;
                }

                if (sumCarry > 0) {
                    result[index] += sumCarry;
                }

                k++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                if (i > 0 || result[i] > 0) {
                    sb.append(result[i]);
                }
            }

            return sb.toString();
        }

        private int intValue(char ch) {
            return ch - '0';
        }
    }
}
