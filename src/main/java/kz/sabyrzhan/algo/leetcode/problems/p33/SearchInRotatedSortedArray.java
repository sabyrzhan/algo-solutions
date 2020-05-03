package kz.sabyrzhan.algo.leetcode.problems.p33;

/**
 * After identifying the middle point, we must find the sorted part (After first pivot one of two parts is sorted)
 * Then we check weather the target is within sorted or not.
 * If it is in sorted part then we make binary search
 * Else we recursively find pivot in order to find the target within sorted part.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray m = new SearchInRotatedSortedArray();
        int[] values = {4,5,6,7,0,1,2};
        Solution s = m.new Solution();
        int result = s.search(values, 6);
        System.out.println(result);
    }

    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length == 0) {
                return -1;
            }

            if(nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }

            int foundIndex = searchRec(nums, 0, nums.length - 1, target);
            return foundIndex;
        }

        private int searchRec(int[] nums, int start, int end, int target) {
            if(end - start == 1) {
                if(nums[start] == target) {
                    return start;
                } else if(nums[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }

            int left = nums[start];
            int right = nums[end];
            int midIndex = start + ((end - start) / 2);
            int mid = nums[midIndex];
            boolean isLeftSorted = left <= mid;
            if(isLeftSorted) {
                if(left <= target && target <= mid) {
                    return binSearch(nums, start, midIndex, target);
                } else {
                    return searchRec(nums, midIndex, end, target);
                }
            } else {
                if(mid <= target && target <= right) {
                    return binSearch(nums, midIndex, end, target);
                } else {
                    return searchRec(nums, start, midIndex, target);
                }
            }
        }

        private int binSearch(int[] nums, int start, int end, int target) {
            if(end - start == 1) {
                if(nums[end] == target) {
                    return end;
                } else if(nums[start] == target) {
                    return start;
                } else {
                    return -1;
                }
            }

             int mid = (end - start) / 2;
             int midNum = nums[start + mid];
             if(midNum == target) {
                 return start + mid;
             } else {
                 if(target <= midNum) {
                     return binSearch(nums, start, start + mid, target);
                 } else {
                     return binSearch(nums, start + mid, end, target);
                 }
             }
        }
    }
}
