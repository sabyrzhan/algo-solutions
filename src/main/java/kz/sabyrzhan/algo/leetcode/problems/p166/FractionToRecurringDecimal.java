package kz.sabyrzhan.algo.leetcode.problems.p166;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        FractionToRecurringDecimal p = new FractionToRecurringDecimal();

       int input = 1;
       int input2 = 2;

        Solution s = p.new Solution();
        String result = s.fractionToDecimal(input, input2);
        System.out.println(result);
    }

    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            long x = numerator;
            long y = denominator;

            double c = (double)x / y;
            if (c == (long)c) {
                return String.valueOf((long)c);
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (numerator < 0 && denominator > 0 || denominator < 0 && numerator > 0) {
                stringBuilder.append("-");
            }

            long numerator1 = Math.abs(x);
            long denominator1 = Math.abs(y);

            stringBuilder.append(numerator1 / denominator1);
            stringBuilder.append(".");

            long remainder = numerator1 % denominator1;
            HashMap<Long, Integer> remainders = new HashMap<>();
            while(remainders.get(remainder) == null) {
                remainders.put(remainder, stringBuilder.length());
                stringBuilder.append(10 * remainder / denominator1);
                remainder = 10 * remainder % denominator1;
            }

            stringBuilder.insert(remainders.get(remainder), "(");
            stringBuilder.append(")");
            String result = stringBuilder.toString().replace("(0)", "");
            return result;
        }
    }
}
