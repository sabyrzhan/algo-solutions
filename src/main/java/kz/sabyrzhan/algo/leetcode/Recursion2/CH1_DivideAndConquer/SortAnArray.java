package kz.sabyrzhan.algo.leetcode.Recursion2.CH1_DivideAndConquer;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        SortAnArray s = new SortAnArray();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int[] arr = {5,2,3,1};
        int[] result = s.sortArray(arr);
        System.out.println(Arrays.toString(result));
    }

    public class Solution {
        public int[] sortArray(int[] nums) {
            mergeSort(nums,0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if (end > start) {
                int mid = start + (end - start) / 2;
                mergeSort(nums, start, mid);
                mergeSort(nums, mid + 1, end);
                merge(nums, mid, start, end);
            }
        }

        public int[] merge(int[] arr, int middle, int l, int r) {
            // 0 1 2 3 4 5 6 7
            // 7 - 4 = 3 / 2 = 1;
            //  4 + 1 = 5;
            int[] left = new int[middle - l + 1];
            int[] right = new int[r - middle];

            for(int i = 0, j = l; i < left.length && j <= middle; i++, j++) {
                left[i] = arr[j];
            }

            for (int j = middle + 1, i = 0; j <= r; j++, i++) {
                right[i] = arr[j];
            }

            int i = 0, j = 0;
            int k = l;
            while(i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            while(i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }

            while(j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }

            return arr;
        }
    }
}
