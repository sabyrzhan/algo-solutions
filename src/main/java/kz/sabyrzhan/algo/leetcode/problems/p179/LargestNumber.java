package kz.sabyrzhan.algo.leetcode.problems.p179;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber p = new LargestNumber();

       int[] input = new int[] {10,2};

        Solution s = p.new Solution();
        String result = s.largestNumber(input);
        System.out.println(result);
    }

    class Solution {
        public String largestNumber(int[] nums) {
            String[] str = new String[nums.length];
            for(int i = 0; i < nums.length; i++) {
                str[i] = String.valueOf(nums[i]);
            }
            Comparator<String> cmp = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String str1 = o1 + o2;
                    String str2 = o2 + o1;
                    return str2.compareTo(str1);
                }
            };

            Arrays.sort(str, cmp);
            if (str[0].charAt(0) == '0') {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for(String s : str) {
                sb.append(s);
            }

            return sb.toString();
        }
    }
}
