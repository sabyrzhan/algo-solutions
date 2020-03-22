package kz.sabyrzhan.algo.leetcode.p144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal p = new BinaryTreePreorderTraversal();

        TreeNode node1 = p.new TreeNode(1);
        TreeNode node2 = p.new TreeNode(2);
        TreeNode node3 = p.new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        Solution s = p.new Solution();
        List<Integer> result = s.preorderTraversal(node1);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> items = new ArrayList<>();

            while(root != null) {
                items.add(root.val);
                if (root.right != null) {
                    stack.add(root.right);
                }

                root = root.left;
                if (root == null && !stack.isEmpty()) {
                    root = stack.pop();
                }
            }

            return items;
        }

        private void dfs(TreeNode node, List<Integer> items) {
            if (node == null) {
                return;
            }

            items.add(node.val);
            dfs(node.left, items);
            dfs(node.right, items);
        }
    }
}
