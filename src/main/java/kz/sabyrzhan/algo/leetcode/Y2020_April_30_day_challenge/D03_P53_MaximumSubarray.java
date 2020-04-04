package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.HashSet;
import java.util.Set;

public class D03_P53_MaximumSubarray {
    public static void main(String[] args) {
        D03_P53_MaximumSubarray p = new D03_P53_MaximumSubarray();
        p.execute();
    }

    private void execute() {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};

        Solution s = new Solution();
        int result = s.maxSubArray(input);
        System.out.println(result);
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int tmp = 0;
            for(int a : nums) {
                tmp = Math.max(a + tmp,a);
                max = Math.max(tmp, max);
            }

            return max;
        }
    }
}
