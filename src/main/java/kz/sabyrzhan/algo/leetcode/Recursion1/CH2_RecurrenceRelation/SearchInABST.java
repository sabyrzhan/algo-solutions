package kz.sabyrzhan.algo.leetcode.Recursion1.CH2_RecurrenceRelation;

public class SearchInABST {
    public static void main(String[] args) {
        SearchInABST reverseLinkedList = new SearchInABST();
        reverseLinkedList.execute();
    }

    public void execute() {
        Solution solution = new Solution();

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        TreeNode result = solution.searchBST(treeNode, 5);
        System.out.println(result);
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

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }

            if (val == root.val) {
                return root;
            }

            if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }
}
