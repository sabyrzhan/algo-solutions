package kz.sabyrzhan.algo.leetcode.problems.p6;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        int index = 0;
        int incr = 0;

        StringBuilder[] b = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            b[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            b[index].append(s.charAt(i));
            if (index == 0) {
                incr = 1;
            }

            if (index == numRows - 1) {
                incr = -1;
            }
            index+=incr;
        }

        for(int i = 1; i < numRows; i++) {
            b[0].append(b[i]);
        }

        return b[0].toString();
    }
}
