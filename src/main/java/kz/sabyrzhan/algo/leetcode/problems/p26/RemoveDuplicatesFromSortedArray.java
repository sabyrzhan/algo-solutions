package kz.sabyrzhan.algo.leetcode.problems.p26;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray m = new RemoveDuplicatesFromSortedArray();
        m.execute();
    }

    private void execute() {
        int[] values = new int[] {1,2,3};

        Solution s = new Solution();
        int result = s.removeDuplicates(values);
        System.out.println(result);
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for(int num : nums) {
                if (i == 0 || nums[i - 1] < num) {
                    nums[i++] = num;
                }
            }

            return i;
        }
    }
}
