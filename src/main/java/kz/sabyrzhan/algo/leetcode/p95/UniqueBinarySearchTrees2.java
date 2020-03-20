package kz.sabyrzhan.algo.leetcode.p95;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UniqueBinarySearchTrees2 {
    public static void main(String[] args) {
        UniqueBinarySearchTrees2 p = new UniqueBinarySearchTrees2();


        int input = 3;

        Solution s = p.new Solution();
        List<TreeNode> result = s.generateTrees(input);
        System.out.println(result);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> result = new ArrayList<>();
            if (start > end) {
                result.add(null);
                return result;
            }

            for (int rootValue = start; rootValue <= end; rootValue++) {
                List<TreeNode> leftSubTrees = generateTrees(start, rootValue - 1);
                List<TreeNode> rightSubTrees = generateTrees(rootValue + 1, end);

                for (TreeNode leftSubTree : leftSubTrees) {
                    for (TreeNode rightSubTree : rightSubTrees) {
                        TreeNode n = new TreeNode(rootValue);
                        n.left = leftSubTree;
                        n.right = rightSubTree;
                        result.add(n);
                    }
                }
            }

            return result;
        }
    }
}
