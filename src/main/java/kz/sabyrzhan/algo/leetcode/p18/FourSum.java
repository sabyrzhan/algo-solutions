package kz.sabyrzhan.algo.leetcode.p18;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }

    public static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 3; i++) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    int left = j + 1;
                    int right = nums.length - 1;

                    while(left < right) {
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[left];
                        int d = nums[right];
                        int sum = a + b + c + d;

                        if(sum == target) {
                            List<Integer> items = new ArrayList<>();
                            items.add(a);
                            items.add(b);
                            items.add(c);
                            items.add(d);
                            result.add(items);

                            int leftValue = nums[left];
                            while(left < nums.length && nums[left] == leftValue) {
                                left++;
                            }

                            int rightValue = nums[right];
                            while(right >= 0 && nums[right] == rightValue) {
                                right--;
                            }
                        } else if(sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }

                    while((j + 1) < nums.length && nums[j + 1] == nums[j]) {
                        j++;
                    }
                }

                while((i + 1) < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
            }

            return result;
        }
    }
}
