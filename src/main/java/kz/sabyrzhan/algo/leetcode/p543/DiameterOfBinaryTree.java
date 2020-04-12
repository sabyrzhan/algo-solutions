package kz.sabyrzhan.algo.leetcode.p543;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree p = new DiameterOfBinaryTree();
        p.execute();
    }

    private void execute() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        TreeNode left = treeNode.left;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        Solution s = new Solution();
        int result = s.diameterOfBinaryTree(treeNode);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            recurse(root);
            return max;
        }

        public int recurse(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int first = recurse(root.left);
            int second = recurse(root.right);

            max = Math.max(max, first + second);

            return 1 + Math.max(first, second);
        }
    }
}
