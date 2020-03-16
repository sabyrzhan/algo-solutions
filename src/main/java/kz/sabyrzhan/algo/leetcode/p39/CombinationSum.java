package kz.sabyrzhan.algo.leetcode.p39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] items = new int[] {2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(items, target);
        System.out.println(result);
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            combinationSumRecursive(candidates, target, result, new ArrayList<>(), 0);
            return result;
        }

        private void combinationSumRecursive(int[] cans, int target, List<List<Integer>> result,
                                             ArrayList<Integer> list, int index) {
            if (target < 0) {
                return;
            }

            if (target == 0) {
                result.add((ArrayList) list.clone());
                return;
            }

            for (int i = index; i < cans.length; i++) {
                list.add(cans[i]);
                combinationSumRecursive(cans, target - cans[i], result, list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
