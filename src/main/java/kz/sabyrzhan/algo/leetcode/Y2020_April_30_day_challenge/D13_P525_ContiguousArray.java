package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.HashMap;
import java.util.Map;

public class D13_P525_ContiguousArray {
    public static void main(String[] args) {
        D13_P525_ContiguousArray p = new D13_P525_ContiguousArray();
        p.execute();
    }

    private void execute() {
        int[] input = {0,1,0};

        Solution s = new Solution();
        int result = s.findMaxLength(input);
        System.out.println(result);
    }

    class Solution {
        public int findMaxLength(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) nums[i] = -1;
            }

            Map<Integer, Integer> sumToIndex = new HashMap<>();
            sumToIndex.put(0, -1);
            int sum = 0, max = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sumToIndex.containsKey(sum)) {
                    max = Math.max(max, i - sumToIndex.get(sum));
                }
                else {
                    sumToIndex.put(sum, i);
                }
            }

            return max;
        }
    }
}
