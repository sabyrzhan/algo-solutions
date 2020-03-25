package kz.sabyrzhan.algo.leetcode.p163;

import java.util.ArrayList;
import java.util.List;

// Decription
// https://www.lintcode.com/problem/missing-ranges/description
public class MissingRanges {
    public static void main(String[] args) {
        MissingRanges p = new MissingRanges();

       int[] input = new int[] {0, 1, 2, 3, 7};
       int lower = 0;
       int upper = 7;

        Solution s = p.new Solution();
        List<String> result = s.findMissingRanges(input, lower, upper);
        System.out.println(result);
    }

    public class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            int startIndex = 0;
            while(startIndex < nums.length && nums[startIndex] < lower) {
                startIndex++;
            }

            List<String> result = new ArrayList<>();
            int preValue = lower - 1;
            for(int i = startIndex; i < nums.length && nums[startIndex] <= upper; i++) {
                int current = nums[i];
                if (current == preValue) {
                    continue;
                }

                if (preValue + 1 <= current - 1) {
                    result.add(buildStr(preValue, current));
                }
                preValue = current;
            }

            if (preValue + 1 <= upper) {
                result.add(buildStr(preValue, upper));
            }

            return result;
        }

        private String buildStr(int lower, int upper) {
            if (lower + 1 == upper - 1) {
                return (lower + 1) + "";
            }

            return (lower + 1) + " -> " + (upper - 1);
        }
    }
}
