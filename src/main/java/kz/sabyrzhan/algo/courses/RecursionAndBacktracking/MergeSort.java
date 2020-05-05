package kz.sabyrzhan.algo.courses.RecursionAndBacktracking;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int[] arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public class Solution {

        public void sort(int[] arr) {
            sort(0, arr.length - 1, arr);
        }

        private void sort(int left, int right, int[] arr) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                sort(left, mid, arr);
                sort(mid + 1, right, arr);
                merge(left, mid, right, arr);
            }
        }

        private void merge(int left, int mid, int right, int[] arr) {
            int[] leftArr = new int[mid - left + 1];
            int[] rightArr = new int[right - mid];

            int j = 0;
            for(int i = left; i <= mid; i++) {
                leftArr[j++] = arr[i];
            }

            j = 0;
            for(int i = mid + 1; i <= right; i++) {
                rightArr[j++] = arr[i];
            }

            int leftIndex = 0;
            int rightIndex = 0;
            while(leftIndex < leftArr.length && rightIndex < rightArr.length) {
                if(leftArr[leftIndex] > rightArr[rightIndex]) {
                    arr[left++] = rightArr[rightIndex++];
                } else {
                    arr[right++] = leftArr[leftIndex++];
                }
            }

            while(leftIndex < leftArr.length) {
                arr[left++] = leftArr[leftIndex++];
            }

            while(rightIndex < rightArr.length) {
                arr[right++] = rightArr[rightIndex++];
            }
        }
    }
}
