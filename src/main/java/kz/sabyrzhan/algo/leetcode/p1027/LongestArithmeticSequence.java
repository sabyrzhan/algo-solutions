package kz.sabyrzhan.algo.leetcode.p1027;

import java.util.*;

public class LongestArithmeticSequence {
    public static void main(String[] args) {
        LongestArithmeticSequence p = new LongestArithmeticSequence();

        int[] input = new int[] {
                3,6,9,12
        };

        Solution s = p.new Solution();
        int result = s.longestArithSeqLength(input);
        System.out.println(result);
    }

    class Solution {
        public int longestArithSeqLength(int[] A) {
            int res = 2, n = A.length;
            HashMap<Integer, Integer>[] dp = new HashMap[n];
            for (int j = 0; j < A.length; j++) {
                dp[j] = new HashMap<>();
                for (int i = 0; i < j; i++) {
                    int d = A[j] - A[i];
                    dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                    res = Math.max(res, dp[j].get(d));
                }
            }
            return res;
        }
    }
}
