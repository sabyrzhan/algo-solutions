package kz.sabyrzhan.algo.leetcode.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets p = new Subsets();

        int[] n = new int[] {4,4,4,1,4};

        Solution s = p.new Solution();
        List<List<Integer>> result = s.subsetsWithDup(n);
        System.out.println(result);
    }

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            recurse(nums, result, new ArrayList<>(), 0);
            return result;
        }

        private void recurse(int[] nums, List<List<Integer>> result, List<Integer> items, int start) {
            result.add(new ArrayList<>(items));
            for(int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                items.add(nums[i]);
                recurse(nums, result, items, i+1);
                items.remove(items.size() - 1);
            }
        }
    }
}
