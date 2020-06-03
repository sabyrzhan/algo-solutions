package kz.sabyrzhan.algo.leetcode.Recursion2.CH1_DivideAndConquer;

import javax.swing.tree.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        ValidateBST s = new ValidateBST();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode treeNode = new TreeNode(2, left, right);
        System.out.println(s.isValidBST(treeNode));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidRecurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidRecurse(TreeNode node, long left, long right) {
            if (node == null) {
                return true;
            }

            if (node.val <= left || node.val >= right) {
                return false;
            }

            return isValidRecurse(node.left, left, node.val) && isValidRecurse(node.right, node.val, right);

        }
    }
}
