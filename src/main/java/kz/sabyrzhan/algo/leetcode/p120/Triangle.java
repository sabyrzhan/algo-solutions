package kz.sabyrzhan.algo.leetcode.p120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle p = new Triangle();

        List<List<Integer>> params = new ArrayList<>();
        params.add(Arrays.asList(2));
        params.add(Arrays.asList(3,4));
        params.add(Arrays.asList(6,5,7));
        params.add(Arrays.asList(4,1,8,3));

        Solution s = p.new Solution();
        int result = s.minimumTotal(params);
        System.out.println(result);
    }

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] A = new int[triangle.size() + 1];

            for(int i = triangle.size() - 1; i >= 0; i--) {
                for(int j = 0; j < triangle.get(i).size(); j++) {
                    A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
                    System.out.println(Arrays.toString(A));
                }
            }
            return A[0];
        }
    }
}
