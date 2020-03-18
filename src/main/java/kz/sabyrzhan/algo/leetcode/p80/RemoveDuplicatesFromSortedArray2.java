package kz.sabyrzhan.algo.leetcode.p80;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray2 p = new RemoveDuplicatesFromSortedArray2();

        int[] input = new int[] {1,1,1,2,2,3};

        Solution s = p.new Solution();
        int result = s.removeDuplicates(input);
        System.out.println(result);
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for(int n : nums) {
                if (i < 2 || n > nums[i - 2]) {
                    nums[i++] = n;
                }
            }

            return i;
        }
    }
}
