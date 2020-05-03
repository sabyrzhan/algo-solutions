package kz.sabyrzhan.algo.leetcode.problems.p18;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum p = new FourSum();
        p.execute();
    }

    public void execute() {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[] {-3,-2,-1,0,0,1,2,3}, 0));
    }

    class Solution {
        private int[] nums;
        private int target;
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            this.nums = nums;
            this.target = target;
            for(int i = 0; i < nums.length - 3; i++) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    doWhile(i, j);
                    while(j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
                }
                while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            }

            return result;
        }

        public void doWhile(int i, int j) {
            int a = nums[i];
            int b = nums[j];
            int m = j + 1;
            int n = nums.length - 1;
            while(m < n) {
                int c = nums[m];
                int d = nums[n];
                int sum = a + b + c + d;
                if (sum == target) {
                    List<Integer> arr = Arrays.asList(a,b,c,d);
                    Collections.sort(arr);
                    result.add(arr);
                    while(m + 1 < n && nums[m + 1] == nums[m]) m++;
                    while(n - 1 >= 0 && nums[n - 1] == nums[n]) n--;
                    m++;
                    n--;
                } else if(sum < target) {
                    m++;
                } else {
                    n--;
                }
            }
        }
    }
}
