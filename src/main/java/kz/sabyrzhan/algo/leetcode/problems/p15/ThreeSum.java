package kz.sabyrzhan.algo.leetcode.problems.p15;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while( j < k) {
                int b = nums[j];
                int c = nums[k];
                int r = a + b + c;
                String key = a + "" + b + "" + c;
                if (visited.contains(key)) {
                    j++;
                    continue;
                }


                if (r < 0) {
                    j++;
                }

                if (r > 0) {
                    k--;
                }

                if (r == 0) {
                    visited.add(key);
                    result.add(Arrays.asList(a,b,c));
                    j++;
                }
            }
        }

        return result;
    }
}
