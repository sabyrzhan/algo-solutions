package kz.sabyrzhan.algo.leetcode.problems.p75;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors p = new SortColors();

        int[] input = new int[] {2,2,2,2,2,0};

        Solution s = p.new Solution();
        s.sortColors(input);
        System.out.println(Arrays.toString(input));
    }

    class Solution {
        public void sortColors(int[] nums) {
            int p1 = 0;
            int p2 = nums.length - 1;
            int index = 0;
            while(index <= p2) {
                if (nums[index] == 0) {
                    nums[index] = nums[p1];
                    nums[p1] = 0;
                    p1++;
                }

                if (nums[index] == 2) {
                    nums[index] = nums[p2];
                    nums[p2] = 2;
                    p2--;
                    index--;
                }
                index++;
            }
        }
    }
}
