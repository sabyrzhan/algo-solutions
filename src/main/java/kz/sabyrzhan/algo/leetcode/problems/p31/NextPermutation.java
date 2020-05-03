package kz.sabyrzhan.algo.leetcode.problems.p31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation s = new NextPermutation();
        int[] values = new int[] {2,3,1};
        Solution ss = s.new Solution();
        System.out.println(Arrays.toString(values));
        ss.nextPermutation(values);
        System.out.println(Arrays.toString(values));
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            if(nums == null || nums.length == 1) {
                return;
            }

            if(nums.length == 2) {
                if(nums[1] > nums[0]) {
                    int tmp = nums[1];
                    nums[1] = nums[0];
                    nums[0] = tmp;
                }

                return;
            }

            List<Integer> passedElements = new ArrayList<>();
            for(int i = nums.length - 1; i >= 0; i--) {
                if(!passedElements.contains(nums[i])) {
                    passedElements.add(nums[i]);
                }

                if(i == 0) {
                    Arrays.sort(nums);
                    break;
                }

                if(nums[i - 1] < nums[i]) {
                    if(!passedElements.contains(nums[i - 1])) {
                        passedElements.add(nums[i - 1]);
                    }
                    Collections.sort(passedElements);
                    int currIndex = passedElements.indexOf(nums[i - 1]);
                    int indexToSwapWith = i;
                    if(currIndex + 1 < passedElements.size()) {
                        int nextElement = passedElements.get(currIndex + 1);
                        if(nextElement != nums[i]) {
                            indexToSwapWith = indexOf(nextElement, nums);
                        }
                    }

                    int tmp = nums[i - 1];
                    nums[i - 1] = nums[indexToSwapWith];
                    nums[indexToSwapWith] = tmp;
                    sort(nums, i);
                    break;
                }
            }
        }

        private int[] sort(int[] nums, int startIndex) {
            for(int i = startIndex; i < nums.length; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[j] < nums[i]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }

            return nums;
        }

        private int indexOf(int elem, int[] nums) {
            for(int i = nums.length - 1; i >= 0; i--) {
                if(nums[i] == elem) {
                    return i;
                }
            }

            return -1;
        }
    }
}
