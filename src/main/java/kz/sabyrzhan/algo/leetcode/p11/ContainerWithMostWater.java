package kz.sabyrzhan.algo.leetcode.p11;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater p = new ContainerWithMostWater();

        int[] input = new int[] {
                1,8,6,2,5,4,8,3,7
        };

        Solution solution = p.new Solution();
        System.out.println(solution.maxArea(input));
    }

    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int maxArea = -1;

            while(left < right) {
                int leftVal = height[left];
                int rightVal = height[right];
                int distance = right - left;
                int maxHeight = Math.min(left, right);
                int area = distance * maxHeight;

                if (area > maxArea) {
                    maxArea = area;
                }

                if (leftVal <= rightVal) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }
}