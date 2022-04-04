package kz.sabyrzhan.algo.leetcode.problems.p704;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while(startIndex <= endIndex) {
            int valueIndex = (startIndex + endIndex) / 2;
            int value = nums[valueIndex];
            if (value == target) {
                return valueIndex;
            } else if(value < target) {
                startIndex = valueIndex + 1;
            } else {
                endIndex = valueIndex - 1;
            }
        }
        
        return -1;
    }
}
