package kz.sabyrzhan.algo.leetcode.p13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger p = new RomanToInteger();

        String s = "III";

        Solution solution = p.new Solution();
        System.out.println(solution.romanToInt(s));
    }

    class Solution {
        public int romanToInt(String s) {
            Map<Character,  Integer> kv = new HashMap<>();
            char[] roms = {
                    'M', 'D', 'C', 'L', 'X', 'V', 'I'
            };

            int[] vals = {
                    1000, 500, 100, 50, 10, 5, 1
            };

            for(int i = 0; i < roms.length; i++) {
                kv.put(roms[i], i);
            }
            int sum = 0;

            for(int i = 0; i < s.length() - 1; i++) {
                int currVal = vals[kv.get(s.charAt(i))];
                int nextVal = vals[kv.get(s.charAt(i + 1))];
                if (currVal < nextVal) {
                    sum -= currVal;
                } else {
                    sum += currVal;
                }
            }

            sum += vals[kv.get(s.charAt(s.length() - 1))];

            return sum;
        }
    }
}