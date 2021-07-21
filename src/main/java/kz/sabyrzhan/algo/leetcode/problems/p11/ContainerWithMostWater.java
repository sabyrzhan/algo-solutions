package kz.sabyrzhan.algo.leetcode.problems.p11;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while(left <= right) {
            int leftArea = height[left];
            int rightArea = height[right];
            int distance = right - left;
            int area = distance * Math.min(leftArea, rightArea);
            if (area >= maxArea) {
                maxArea = area;
            }

            if (leftArea < rightArea) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}