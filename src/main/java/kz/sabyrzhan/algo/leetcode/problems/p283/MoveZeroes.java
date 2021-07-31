package kz.sabyrzhan.algo.leetcode.problems.p283;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        for(int n : nums) {
            if (n != 0) {
                nums[i++] = n;
            }
        }
        while(i < nums.length) {
            nums[i++] = 0;
        }
    }
}
