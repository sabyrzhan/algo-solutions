package kz.sabyrzhan.algo.leetcode.problems.p1261;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
        FindElementsInAContaminatedBinaryTree p = new FindElementsInAContaminatedBinaryTree();

       TreeNode root = p.new TreeNode(-1);
       root.left = p.new TreeNode(-1);
       root.right = p.new TreeNode(-1);

       TreeNode left = root.left;
       left.left = p.new TreeNode(-1);
       left.right = p.new TreeNode(-1);

        FindElements s = p.new FindElements(root);
        boolean result = s.find(1);
        System.out.println(result);
        result = s.find(3);
        System.out.println(result);
        result = s.find(5);
        System.out.println(result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class FindElements {
        TreeNode root;
        Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            this.root = root;
            root.val = 0;
            set.add(root.val);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode e = queue.peek();
                if (e.left != null) {
                    e.left.val = 2 * e.val + 1;
                    set.add(e.left.val);
                    queue.add(e.left);
                }

                if (e.right != null) {
                    e.right.val = 2 * e.val + 2;
                    set.add(e.right.val);
                    queue.add(e.right);
                }

                queue.poll();
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private boolean dfs(TreeNode root, int value) {
            if (root == null) {
                return false;
            }

            if (root.val == value) {
                return true;
            }

            return dfs(root.left, value) || dfs(root.right, value);
        }
    }
}
