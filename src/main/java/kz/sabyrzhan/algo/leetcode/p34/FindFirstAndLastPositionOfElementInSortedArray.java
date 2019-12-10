package kz.sabyrzhan.algo.leetcode.p34;

import java.util.Arrays;
/*
    Divide search phase into two:
    1) search for left index
    2) search for right index

    Runtime complexity: O(logn) + O(logn) = 2 * O(logn) ~ O(logn)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray m = new FindFirstAndLastPositionOfElementInSortedArray();
        Solution s = m.new Solution();
        int[] ranges = s.searchRange(new int[] {2,2}, 2);
        System.out.println(Arrays.toString(ranges));
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0) {
                return new int[] {-1,-1};
            }

            if(nums.length == 1) {
                return nums[0] == target ? new int[] {0,0} : new int[]{-1,-1};
            }

            int leftIndex = findRec(nums, 0, nums.length - 1, target, true);
            int rightIndex = findRec(nums, 0, nums.length - 1, target, false);

            return new int[] {leftIndex, rightIndex};
        }

        int findRec(int[] nums, int start, int end, int target, boolean findLeft) {
            if(end - start == 0) {
                return nums[end] == target ? end : -1;
            }

            if(end - start == 1) {
                if(nums[start] == nums[end] && nums[start] == target) {
                    if(findLeft) {
                        return start;
                    } else {
                        return end;
                    }
                } else {
                    if(nums[start] == target) {
                        return start;
                    } else if(nums[end] == target) {
                        return end;
                    } else {
                        return -1;
                    }
                }
            }

            int midIndex = start + ((end - start) / 2);
            int mid = nums[midIndex];

            if(target < mid) {
                return findRec(nums, start, midIndex, target, findLeft);
            }

            if(target > mid) {
                return findRec(nums, midIndex, end, target, findLeft);
            }

            if(findLeft) {
                return findRec(nums, start, midIndex, target, true);
            } else {
                return findRec(nums,  midIndex, end, target, false);
            }
        }
    }
}
