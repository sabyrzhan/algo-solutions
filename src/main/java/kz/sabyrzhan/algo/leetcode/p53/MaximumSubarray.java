package kz.sabyrzhan.algo.leetcode.p53;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray p = new MaximumSubarray();
        p.execute();
    }

    private void execute() {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(input));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int resultMax = nums[0];
            int intermediateMax = nums[0];
            for(int i = 1; i < nums.length; i++) {
                intermediateMax = Math.max(intermediateMax + nums[i], nums[i]);
                resultMax = Math.max(resultMax, intermediateMax);
            }

            return resultMax;
        }
    }
}
