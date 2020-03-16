package kz.sabyrzhan.algo.leetcode.p55;

public class JumpGame {
    public static void main(String[] args) {
        int[] input = new int[]{2,3,1,1,4};
        JumpGame p = new JumpGame();
        Solution s = p.new Solution();
        System.out.println(s.canJump(input));
    }

    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int lastValid = len-1;
            for (int i=len-2; i>=0; i--) {
                if (nums[i]+i >= lastValid) lastValid = i;
            }

            return lastValid == 0;
        }
    }
}
