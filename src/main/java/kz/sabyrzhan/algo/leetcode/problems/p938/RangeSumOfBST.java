package kz.sabyrzhan.algo.leetcode.problems.p938;

public class RangeSumOfBST {
    public static void main(String[] args) {
        RangeSumOfBST p = new RangeSumOfBST();

       TreeNode root = p.new TreeNode(10);
       root.left = p.new TreeNode(5);
       root.right = p.new TreeNode(15);

        TreeNode left = root.left;
        left.left = p.new TreeNode(3);
        left.right = p.new TreeNode(7);

        TreeNode right = root.right;
        right.right = p.new TreeNode(18);

        int l = 7;
        int r = 15;

        Solution s = p.new Solution();
        int result = s.rangeSumBST(root, l, r);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            return dfsSum(root, L, R);
        }

        private int dfsSum(TreeNode root, int l, int r) {
            if (root == null) {
                return 0;
            }

            int sum = dfsSum(root.left, l, r) + dfsSum(root.right, l, r);
            if (l <= root.val && root.val <= r) {
                sum += root.val;
            }

            return sum;
        }
    }
}
