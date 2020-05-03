package kz.sabyrzhan.algo.leetcode.problems.p15;

import java.util.*;

public class TreeSum {
    public static void main(String[] args) {
        TreeSum p = new TreeSum();

        int[] input = {-1, 0, 1, 2, -1, -4};

        Solution solution = p.new Solution();
        System.out.println(solution.threeSum(input));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 2) return new ArrayList<>();

            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();
            for(int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (nums[i] != nums[i - 1])) {
                    int curr = nums[i];
                    int j = i + 1;
                    int k = nums.length - 1;
                    while(j < k) {
                        int sum = curr + nums[j] + nums[k];
                        if (sum == 0) {
                            result.add(Arrays.asList(curr, nums[j], nums[k]));
                            j++;
                            k--;
                        } else if (sum < 0)  {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }

            return new ArrayList<>(result);
        }
    }
}