package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.Arrays;

public class D03_P283_MoveZeroes {
    public static void main(String[] args) {
        D03_P283_MoveZeroes p = new D03_P283_MoveZeroes();
        p.execute();
    }

    private void execute() {
        int[] input = {};

        Solution s = new Solution();
        s.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int zeroIndex = 0;
            while(zeroIndex < nums.length) {
                if (nums[zeroIndex] == 0) {
                    for(int i = zeroIndex + 1; i < nums.length; i++) {
                        if (nums[i] != 0) {
                            nums[zeroIndex] = nums[i];
                            nums[i] = 0;
                            break;
                        }
                    }
                }

                zeroIndex++;
            }
        }
    }
}
