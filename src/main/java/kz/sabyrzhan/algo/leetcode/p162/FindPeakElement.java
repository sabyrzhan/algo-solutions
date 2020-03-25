package kz.sabyrzhan.algo.leetcode.p162;

// Decription
// https://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement p = new FindPeakElement();

       int[] input = new int[] {1,2,1,3,5,6,4};

        Solution s = p.new Solution();
        int result = s.findPeakElement(input);
        System.out.println(result);
    }

    class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }

            if (nums.length < 3) {
                return nums[0] > nums[1] ? 0 : 1;
            }

            for(int i = 1; i < nums.length - 1; i++) {
                if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }

            return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
        }
    }
}
