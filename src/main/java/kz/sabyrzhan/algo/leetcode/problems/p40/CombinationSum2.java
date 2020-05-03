package kz.sabyrzhan.algo.leetcode.problems.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] list = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(list, target);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            combinationSum2Recursive(candidates, target, result, new ArrayList<>(), 0);;
            return result;
        }

        public void combinationSum2Recursive(int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> list, int index) {
            if (target < 0) {
                return;
            }

            if (target == 0) {
                ArrayList tmpResult = (ArrayList) list.clone();
                result.add(tmpResult);
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                combinationSum2Recursive(candidates, target - candidates[i], result, list, i+1);
                list.remove(list.size() - 1);
                while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                    i++;
                }
            }
        }
    }
}
