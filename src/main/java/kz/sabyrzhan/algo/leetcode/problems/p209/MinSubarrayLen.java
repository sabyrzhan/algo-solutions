package kz.sabyrzhan.algo.leetcode.problems.p209;

import java.util.Arrays;
import java.util.LinkedList;

public class MinSubarrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        LinkedList<Integer> items = new LinkedList<>();

        Arrays.sort(nums);
        int last = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        for(int i = 0, j = nums.length - 1; i < last; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        int sum = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int a = nums[i];
            int b = nums[j];

            if (sum + b >= target) {
                items.add(b);
                sum += b;
                break;
            }

            if (sum + a == target) {
                items.add(a);
                sum += a;
                break;
            }

            if (sum + a > target) {
                items.add(b);
                sum += b;
                j--;
                break;
            }

            items.add(a);
            sum += a;
            i++;
        }

        return sum < target ? 0 : items.size();
    }
}
