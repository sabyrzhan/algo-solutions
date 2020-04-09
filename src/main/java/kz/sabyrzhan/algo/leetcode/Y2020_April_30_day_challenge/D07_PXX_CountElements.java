package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.*;

public class D07_PXX_CountElements {
    public static void main(String[] args) {
        D07_PXX_CountElements p = new D07_PXX_CountElements();
        p.execute();
    }

    private void execute() {
        int[] input = {1,1,2,2};

        Solution s = new Solution();
        int result = s.countElements(input);
        System.out.println(result);
    }

    class Solution {
        public int countElements(int[] arr) {
            Arrays.sort(arr);
            Set<Integer> map = new HashSet<>();

            for(int i = 0; i < arr.length; i++) {
                map.add(arr[i]);
            }

            int count = 0;
            for(int a : arr) {
                if (map.contains(a + 1)) {
                    count++;
                }
            }

            return count;
        }
    }
}
