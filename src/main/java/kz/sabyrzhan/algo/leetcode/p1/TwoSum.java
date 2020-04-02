package kz.sabyrzhan.algo.leetcode.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum p = new TwoSum();

        int[] input = new int[] {
                3,2,4
        };

        int k = 6;

        Solution solution = p.new Solution();
        System.out.println(Arrays.toString(solution.twoSum(input, k)));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                int t = target - nums[i];
                if (map.get(t) != null && i != map.get(t)) {
                    return new int[] {map.get(t), i};
                }
                map.put(nums[i], i);
            }

            return null;
        }
    }
}
