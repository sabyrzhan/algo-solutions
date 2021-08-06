package kz.sabyrzhan.algo.leetcode.problems.p543;

public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root);
        return max;
    }

    private int recurse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int first = recurse(root.left);
        int second = recurse(root.right);

        max = Math.max(max, first + second);

        return 1 + Math.max(first, second);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
