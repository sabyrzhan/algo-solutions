package kz.sabyrzhan.algo.leetcode.problems.p129;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        SumRootToLeafNumbers p = new SumRootToLeafNumbers();

        TreeNode treeNode = p.new TreeNode(4);
        treeNode.left = p.new TreeNode(9);
        treeNode.right = p.new TreeNode(0);

        TreeNode left = treeNode.left;
        left.left = p.new TreeNode(5);
        left.right = p.new TreeNode(1);

        Solution s = p.new Solution();
        int result = s.sumNumbers(treeNode);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            return sum(root, 0);
        }

        public int sum(TreeNode n, int s){
            if (n == null) return 0;
            if (n.right == null && n.left == null) return s*10 + n.val;
            return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
        }
    }
}
