package kz.sabyrzhan.algo.leetcode.problems.p152;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray p = new MaximumProductSubarray();

       int[] nums = new int[] {2,-5,-2,-4,3};

        Solution s = p.new Solution();
        int result = s.maxProduct(nums);
        System.out.println(result);
    }

    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int result = 1;
            for (int i = 0; i < nums.length; i++) {
                result *= nums[i];
            }

            if (result > 0) {
                return result;
            }

            int max = nums[0];
            int min = nums[0];
            result = max;
            System.out.println(Arrays.toString(nums));
            System.out.println("min = " + min + " max = " + max + " curr = " + nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int tmp = max;
                max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
                min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
                System.out.println("min = " + min + " max = " + max + " curr = " + nums[i]);
                if (max > result) {
                    result = max;
                }
            }

            return result;
        }
    }
}
