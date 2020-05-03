package kz.sabyrzhan.algo.leetcode.problems.p46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        Solution s = new Solution();
        List<List<Integer>> permute = s.permute(nums);
        System.out.println(permute);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            permutRecurs(result, nums, 0, nums.length);
            return result;
        }

        private void permutRecurs(List<List<Integer>> list, int[] nums, int l, int r) {
            if (l == r) {
                List<Integer> tmpResult = new ArrayList<>();
                for (int a : nums) {
                    tmpResult.add(a);
                }
                 list.add(tmpResult);
            } else {
                for (int i = l; i < r; i++) {
                    int tmp = nums[i];
                    nums[i] = nums[l];
                    nums[l] = tmp;
                    permutRecurs(list, nums, l + 1, r);
                    tmp = nums[i];
                    nums[i] = nums[l];
                    nums[l] = tmp;
                }
            }
        }
    }
}
