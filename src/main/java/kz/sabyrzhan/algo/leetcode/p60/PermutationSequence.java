package kz.sabyrzhan.algo.leetcode.p60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        PermutationSequence p = new PermutationSequence();
        Solution s = p.new Solution();
        String res = s.getPermutation(n, k);
        System.out.println(res);
    }

    class Solution {
        private void permutRecurs(List<String> resultItems, int[] nums, int k, boolean[] used, StringBuilder sb) {
            if (sb.length() == nums.length) {
                resultItems.add(sb.toString());
                return;
            }

            for (int x = 0; x < nums.length && resultItems.size() < k; x++) {
                if (!used[x]) {
                    used[x] = true;
                    sb.append(nums[x]);
                    permutRecurs(resultItems, nums, k, used, sb);
                    used[x] = false;
                    sb.replace(sb.length() - 1, sb.length(), "");
                }
            }
        }

        public String getPermutation(int n, int k) {
            int[] nums = new int[n];
            for(int i = 1; i <= n; i++) {
                nums[i - 1] = i;
            }
            ArrayList<String> resultItems = new ArrayList<>();
            permutRecurs(resultItems, nums, k, new boolean[n], new StringBuilder());

            return resultItems.get(k - 1);
        }
    }
}
