package kz.sabyrzhan.algo.leetcode.p98;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree p = new ValidateBinarySearchTree();

        TreeNode parent = p.new TreeNode(2);
        parent.left = p.new TreeNode(1);
        parent.right = p.new TreeNode(3);


        Solution s = p.new Solution();
        boolean result = s.isValidBST(parent);
        System.out.println(result);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode treeNode, int min, int max) {
            if (treeNode == null) return true;

            if (treeNode.val >= max || treeNode.val <= min) return false;

            return isValidBST(treeNode.left, min, treeNode.val) && isValidBST(treeNode.right, treeNode.val, max);
        }
    }
}
