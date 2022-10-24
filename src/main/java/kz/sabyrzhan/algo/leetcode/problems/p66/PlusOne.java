package kz.sabyrzhan.algo.leetcode.problems.p66;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int adder = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + adder;
            if (tmp == 10) {
                adder = 1;
                digits[i] = 0;
            } else {
                adder = 0;
                digits[i] = tmp;
            }
        }

        if (adder != 0) {
            int[] result2 = new int[digits.length + 1];
            result2[0] = adder;
            for(int i = 0; i < digits.length; i++) {
                result2[i + 1] = digits[i];
            }
            return result2;
        } else {
            return digits;
        }
    }
}
