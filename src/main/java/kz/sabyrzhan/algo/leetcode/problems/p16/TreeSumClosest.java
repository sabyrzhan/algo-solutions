package kz.sabyrzhan.algo.leetcode.problems.p16;

import java.util.Arrays;

public class TreeSumClosest {
    public static void main(String[] args) {
        TreeSumClosest p = new TreeSumClosest();

        int[] input = {-1, 2, 1, -4};
        int target = 1;

        Solution solution = p.new Solution();
        System.out.println(solution.threeSumClosest(input, target));
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minDistance = Integer.MAX_VALUE;
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k) {
                    int s = curr + nums[j] + nums[k];
                    int dist = Math.abs(target - s);
                    if (minDistance >= dist) {
                        minDistance = dist;
                        sum = s;
                    }

                    if (s == target) {
                        break;
                    }

                    if (s < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }

            return sum;
        }
    }
}