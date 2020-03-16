package kz.sabyrzhan.algo.leetcode.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public static void main(String[] args) {
        int[] a = new int[] {1,1,2};
        Solution s = new Solution();
        List<List<Integer>> lists = s.permuteUnique(a);
        System.out.println(lists);
    }

    public static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            permuteUniqueRecurs(nums, result, new ArrayList<>(), new boolean[nums.length]);
            return result;
        }

        public void permuteUniqueRecurs(int[] nums, List<List<Integer>> result, List<Integer> items, boolean[] used) {
            if (nums.length == items.size()) {
                result.add(new ArrayList<>(items));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    items.add(nums[i]);
                    permuteUniqueRecurs(nums, result, items, used);
                    items.remove(items.size() - 1);
                    used[i] = false;
                    while(i < nums.length - 1 && nums[i + 1] == nums[i]) {
                        i++;
                    }
                }
            }
        }
    }
}
