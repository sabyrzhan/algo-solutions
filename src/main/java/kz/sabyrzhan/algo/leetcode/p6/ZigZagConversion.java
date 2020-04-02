package kz.sabyrzhan.algo.leetcode.p6;

public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion p = new ZigZagConversion();

        String s = "AB";
        int numRows = 1;

        Solution solution = p.new Solution();
        System.out.println(solution.convert(s, numRows));
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (s  == null || s.length() == 0 || numRows < 2) {
                return s;
            }

            StringBuilder[] b = new StringBuilder[numRows];
            for(int i = 0; i < numRows;i++) {
                b[i] = new StringBuilder("");
            }

            int incre = 1;
            int index = 0;
            for(int i = 0; i < s.length(); i++) {
                b[index].append(s.charAt(i));
                if (index == 0) {
                    incre = 1;
                }

                if (index == numRows - 1) {
                    incre = -1;
                }
                index += incre;
            }

            for(int i = 1; i < b.length; i++) {
                b[0].append(b[i]);
            }

            b[0].reverse();

            return b[0].toString();
        }
    }
}