package kz.sabyrzhan.algo.leetcode.problems.p56;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        /*int[][] input = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };*/
        int[][] input = new int[][]{
                {1,4},
                {4,5}
        };
        MergeIntervals p = new MergeIntervals();
        Solution s = p.new Solution();
        int[][] merge = s.merge(input);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0 || intervals.length == 1) return intervals;
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
            LinkedList<int[]> result = new LinkedList<>();
            result.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] prev = result.getLast();
                int[] curr = intervals[i];
                if (prev[1] >= curr[0]) {
                    prev[0] = prev[0] < curr[0] ? prev[0] : curr[0];
                    prev[1] = prev[1] < curr[1] ? curr[1] : prev[1];
                } else {
                    result.add(new int[] {curr[0], curr[1]});
                }
            }

            int[][] resultArr = new int[result.size()][result.get(0).length];
            for (int i = 0; i < result.size(); i++) {
                resultArr[i] = result.get(i);
            }

            return resultArr;
        }
    }
}
