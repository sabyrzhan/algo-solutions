package kz.sabyrzhan.algo.mit6006.mit01_lecture_ex_2d;

public class Find1DPeak {
    public static void main(String[] args) {
        int[] nums = new int[] {70,390,323,95,53,191,428,336,324,219};
        int maxIndex = (nums.length - 1) / 2;
        int maxValue = Integer.MIN_VALUE;
        while(maxIndex >= 0) {
            if(maxIndex == 0) {
                if(nums[0] > nums[1]) {
                    maxIndex = 1;
                    maxValue = nums[1];
                }
            } else if(maxIndex == nums.length - 1) {
                if(nums[maxIndex] > nums[maxIndex - 1]) {
                    maxIndex = maxIndex - 1;
                    maxValue = nums[maxIndex - 1];
                }
            } else {
                if(nums[maxIndex - 1] > nums[maxIndex]) {
                    maxIndex = (maxIndex - 1)/2;
                } else if(nums[maxIndex + 1] > nums[maxIndex]) {
                    maxIndex = maxIndex + (nums.length - maxIndex - 1);
                } else {
                    maxValue = nums[maxIndex];
                    break;
                }
            }
        }

        System.out.println(maxValue);
    }
}
