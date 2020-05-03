package kz.sabyrzhan.algo.leetcode.problems.p22;

import java.util.*;

/**
 * Backtracking technique.
 * TODO: Refactor to DFS algorithm
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses p = new GenerateParentheses();
        p.execute();
    }

    private void execute() {
        Solution s = new Solution();
        List<String> result = s.generateParenthesis(3);
        System.out.println(result);
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            recurse(result, "", n, n);
            return result;
        }

        private void recurse(List<String> result, String item, int left, int right) {
            if (left == 0 && right == 0) {
                result.add(item);
                return;
            }

            if (left > 0) {
                recurse(result, item + "(", left - 1, right);
            }

            if (right > left) {
                recurse(result, item + ")", left, right - 1);
            }
            return;
        }
    }
}
