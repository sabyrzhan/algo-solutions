package kz.sabyrzhan.algo.leetcode.p77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations p = new Combinations();

        int n = 4;
        int k = 2;

        Solution s = p.new Solution();
        List<List<Integer>> combine = s.combine(n, k);
        System.out.println(combine);
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            combine(result, new ArrayList<>(), 1, n, k);
            return result;
        }

        public void combine(List<List<Integer>> result, List<Integer> items, int start, int n, int k) {
            if (k == 0) {
                result.add(new ArrayList<>(items));
            }

            for(int i = start; i <= n; i++) {
                items.add(i);
                combine(result, items, i + 1, n, k - 1);
                items.remove(items.size() - 1);
            }
        }
    }
}
