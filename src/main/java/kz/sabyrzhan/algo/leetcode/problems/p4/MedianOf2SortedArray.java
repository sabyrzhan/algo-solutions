package kz.sabyrzhan.algo.leetcode.problems.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOf2SortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }

        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        List<Integer> items = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            items.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            items.add(nums2[i]);
        }
        Collections.sort(items);
        if (items.size() % 2 != 0) {
            return items.get(items.size() / 2);
        } else {
            double result = items.get(items.size() / 2 - 1) + items.get(items.size() / 2);
            return result / 2;
        }
    }
}
