package kz.sabyrzhan.algo.leetcode.p78;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        SubSets p = new SubSets();

        int[] n = new int[] {1,2,3};

        Solution s = p.new Solution();
        List<List<Integer>> combine = s.subsets(n);
        System.out.println(combine);
    }

    class Solution {
        public List<List<Integer>> subsets(int[] numbers) {
            List<List<Integer>> result = new ArrayList<>();
            combine(result, new ArrayList<>(), numbers,0);
            return result;
        }

        public void combine(List<List<Integer>> result, List<Integer> items, int[] nums, int start) {
            result.add(new ArrayList<>(items));
            for(int i = start; i < nums.length; i++) {
                items.add(nums[i]);
                combine(result, items, nums, i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}
