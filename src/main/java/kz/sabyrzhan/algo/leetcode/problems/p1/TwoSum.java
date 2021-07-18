package kz.sabyrzhan.algo.leetcode.problems.p1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            if (cache.get(second) != null) {
                return new int[]{cache.get(second), i};
            }
            cache.put(nums[i], i);
        }

        return null;
    }
}
