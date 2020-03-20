package kz.sabyrzhan.algo.leetcode.p94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeInOrderTraversal p = new BinaryTreeInOrderTraversal();


        TreeNode parent = p.new TreeNode(1);
        parent.left = null;
        parent.right = p.new TreeNode(2);
        parent.right.left = p.new TreeNode(3);

        Solution s = p.new Solution();
        List<Integer> result = s.inorderTraversal(parent);
        System.out.println(result);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while(curr != null || !stack.isEmpty()) {
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }

            return result;
        }
    }
}
