package kz.sabyrzhan.algo.leetcode.problems.p89;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        GrayCode p = new GrayCode();

        int n = 2;

        Solution s = p.new Solution();
        List<Integer> result = s.grayCode(n);
        System.out.println(result);
    }

    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < 1<<n; i++) {
                result.add(i ^ (i >> 1));
            }

            return result;
        }
    }
}
