package kz.sabyrzhan.algo.leetcode.p199;

import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView p = new BinaryTreeRightSideView();

       TreeNode input = p.new TreeNode(1);
       input.left = p.new TreeNode(2);
       input.right = p.new TreeNode(3);

        TreeNode left = input.left;
        left.right = p.new TreeNode(4);

        TreeNode right = input.right;
        right.right = p.new TreeNode(5);

        Solution s = p.new Solution();
        List<Integer> result = s.rightSideView(input);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            if (root == null) {
                return values;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                values.add(queue.peek().val);
                for(int i = size - 1; i >= 0; i--) {
                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }

                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }

                    queue.poll();
                }
            }
            return values;
        }
    }
}
