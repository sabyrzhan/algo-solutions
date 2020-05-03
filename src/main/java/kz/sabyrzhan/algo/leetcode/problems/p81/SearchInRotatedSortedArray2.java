package kz.sabyrzhan.algo.leetcode.problems.p81;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray2 p = new SearchInRotatedSortedArray2();

        int[] input = new int[] {2,5,6,0,0,1,2};
        int target = 0;

        Solution s = p.new Solution();
        boolean search = s.search(input, 0);
        System.out.println(search);
    }

    class Solution {
        public boolean search(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if (nums[m] == target) return true;
                if (nums[m] == nums[i]) {
                    i++;
                } else if (nums[m] > nums[i]) {
                    if (nums[m] > target && nums[i] <= target) {
                        j = m - 1;
                    } else {
                        i = m + 1;
                    }
                } else {
                    if (nums[m] < target && nums[j] >= target) {
                        i = m + 1;
                    } else {
                        j = m - 1;
                    }
                }
            }

            return false;
        }
    }
}
