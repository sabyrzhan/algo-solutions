package kz.sabyrzhan.algo.leetcode.p1029;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoCityScheduling {
    public static void main(String[] args) {
        TwoCityScheduling p = new TwoCityScheduling();

        int[][] input = new int[][] {
                {10,20},
                {30,200},{400,50},{30,20}
        };

        Solution s = p.new Solution();
        int result = s.twoCitySchedCost(input);
        System.out.println(result);
    }

    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (a1, a2) -> a1[0] - a1[1] - (a2[0] - a2[1]));
            int result = 0;
            for(int i = 0, j = costs.length / 2; i < costs.length / 2 && j < costs.length; i++, j++) {
                result += costs[i][0];
                result += costs[j][1];
            }

            return result;
        }
    }
}
