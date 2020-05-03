package kz.sabyrzhan.algo.leetcode.problems.p12;

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman p = new IntegerToRoman();

        int num = 3;

        Solution solution = p.new Solution();
        System.out.println(solution.intToRoman(num));
    }

    class Solution {
        public String intToRoman(int num) {
            String[] roms = {
                    "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
            };

            int[] vals = {
                    1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
            };

            int i = 0;

            StringBuilder sb = new StringBuilder();

            while(num > 0) {
                if (num - vals[i] >= 0) {
                    sb.append(roms[i]);
                    num -= vals[i];
                } else {
                    i++;
                }
            }

            return sb.toString();
        }
    }
}