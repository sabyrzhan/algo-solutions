package kz.sabyrzhan.algo.leetcode.p113;

import sun.security.x509.CertificateSubjectName;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        PathSum2 p = new PathSum2();

        TreeNode parent = p.new TreeNode(5);
        parent.left = p.new TreeNode(4);
        parent.right = p.new TreeNode(8);

        TreeNode left = parent.left;
        left.left = p.new TreeNode(11);

        TreeNode right = parent.right;
        right.left = p.new TreeNode(13);
        right.right = p.new TreeNode(4);

        left = left.left;
        left.left = p.new TreeNode(7);
        left.right = p.new TreeNode(2);

        right = right.right;
        right.left = p.new TreeNode(5);
        right.right = p.new TreeNode(1);

        int sum = 22;

        Solution s = p.new Solution();
        List<List<Integer>> result = s.pathSum(parent, sum);
        System.out.println(result);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "[ left = " + (left != null ? left.val : null) + ", right = " + (right != null ? right.val : null);
        }
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(root, sum, result, new ArrayList<>(), 0);
            return result;
        }

        private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> array, int itemsSum) {
            if (root == null) {
                return;
            }

            itemsSum = itemsSum + root.val;


            if (root.left == null && root.right == null && itemsSum == sum) {
                array.add(root.val);
                result.add(new ArrayList<>(array));
                array.remove(array.size() - 1);
                return;
            }

            array.add(root.val);
            dfs(root.left, sum, result, array, itemsSum);
            dfs(root.right, sum, result, array, itemsSum);
            array.remove(array.size() - 1);
        }
    }
}
