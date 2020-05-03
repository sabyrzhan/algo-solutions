package kz.sabyrzhan.algo.leetcode.problems.p283;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes p = new MoveZeroes();
        p.execute();
    }

    private void execute() {
        int[] input = {0,1,0,3,12};

        Solution s = new Solution();
        s.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    class Solution {
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
}
