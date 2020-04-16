package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.Arrays;

public class D15_P238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        D15_P238_ProductOfArrayExceptSelf p = new D15_P238_ProductOfArrayExceptSelf();
        p.execute();
    }

    private void execute() {
        int[] inp = {1,2,3,4};

        Solution s = new Solution();
        int[] result = s.productExceptSelf(inp);
        System.out.println(Arrays.toString(result));
    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] nums2 = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                nums2[i] = calcuateExcept(nums, i);
            }

            return nums2;
        }

        private int calcuateExcept(int[] nums, int except) {
            int product = 1;
            for(int i = 0; i < nums.length; i++) {
                if (i != except) {
                    product *= nums[i];
                }
            }

            return product;
        }
    }
}
