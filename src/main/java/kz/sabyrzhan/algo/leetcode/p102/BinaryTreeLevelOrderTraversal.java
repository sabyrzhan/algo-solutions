package kz.sabyrzhan.algo.leetcode.p102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal p = new BinaryTreeLevelOrderTraversal();

        TreeNode parent = p.new TreeNode(3);
        parent.left = p.new TreeNode(9);
        parent.right = p.new TreeNode(20);

        TreeNode left = parent.left;
        left.left = p.new TreeNode(11);
        left.right = p.new TreeNode(12);
        TreeNode leftRight = left.right;
        leftRight.left = p.new TreeNode(13);

        TreeNode right = parent.right;
        right.left = p.new TreeNode(15);
        right.right = p.new TreeNode(7);
        TreeNode rightRight = right.right;
        rightRight.right = p.new TreeNode(16);

        Solution s = p.new Solution();
        List<List<Integer>> result = s.levelOrder(parent);
        System.out.println(result);
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> tmp;

            while(!queue.isEmpty()) {
                int size = queue.size();
                tmp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }

                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }
                    tmp.add(queue.poll().val);
                }
                result.add(tmp);
            }

            return result;
        }
    }
}
