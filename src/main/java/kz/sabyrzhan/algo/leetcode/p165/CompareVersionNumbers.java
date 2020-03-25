package kz.sabyrzhan.algo.leetcode.p165;

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers p = new CompareVersionNumbers();

       String input = "1.01";
       String input2 = "1.001";

        Solution s = p.new Solution();
        int result = s.compareVersion(input, input2);
        System.out.println(result);
    }

    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1Splitted = version1.split("\\.");
            String[] v2Splitted = version2.split("\\.");

            int max = Math.max(v1Splitted.length, v2Splitted.length);
            for(int i = 0; i < max; i++) {
                int v1 = i < v1Splitted.length ? Integer.valueOf(v1Splitted[i]) : 0;
                int v2 = i < v2Splitted.length ? Integer.valueOf(v2Splitted[i]) : 0;
                if (v1 != v2) {
                    return v1 > v2 ? 1 : -1;
                }
            }

            return 0;
        }
    }
}
