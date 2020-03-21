package kz.sabyrzhan.algo.leetcode.p114;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList p = new FlattenBinaryTreeToLinkedList();

        TreeNode parent = p.new TreeNode(1);
        parent.left = p.new TreeNode(2);
        parent.right = p.new TreeNode(5);

        TreeNode left = parent.left;
        left.left = p.new TreeNode(3);
        left.right = p.new TreeNode(4);

        TreeNode right = parent.right;
        right.right = p.new TreeNode(6);

        Solution s = p.new Solution();
        s.flatten(parent);
        System.out.println(parent);
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
        TreeNode prev;

        public void flatten(TreeNode root) {
            if (root == null)
                return;
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }
}
