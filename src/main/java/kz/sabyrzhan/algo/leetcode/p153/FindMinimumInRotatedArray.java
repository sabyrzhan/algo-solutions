package kz.sabyrzhan.algo.leetcode.p153;

public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedArray p = new FindMinimumInRotatedArray();

       int[] nums = new int[] {4,5,6,7,0,1,2};

        Solution s = p.new Solution();
        int result = s.findMin(nums);
        System.out.println(result);
    }

    class Solution {
        public int findMin(int[] nums) {
            return bst(nums, 0, nums.length - 1);
        }

        private int bst(int[] nums, int l, int r) {
            if (l >= r) {
                return nums[l];
            }

            int mid = (l + r) / 2;

            int minLeft = bst(nums, l, mid);
            int minRight = bst(nums, mid + 1, r);

            return minLeft >= minRight ? minRight : minLeft;
        }
    }
}
