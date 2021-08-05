package kz.sabyrzhan.algo.leetcode.problems.p283;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] result = new int[nums.length];
        int i = 0;
        for(int n : nums) {
            if (n != 0) {
                result[i++] = n;
            }
        }

        for(i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
