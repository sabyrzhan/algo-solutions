package kz.sabyrzhan.algo.leetcode.problems.p173;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        BinarySearchTreeIterator p = new BinarySearchTreeIterator();

       TreeNode treeNode = p.new TreeNode(7);
        treeNode.left = p.new TreeNode(3);
        treeNode.right = p.new TreeNode(15);

        TreeNode right = treeNode.right;
        right.left = p.new TreeNode(9);
        right.right = p.new TreeNode(20);

        BSTIterator s = p.new BSTIterator(treeNode);
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.hasNext());
        System.out.println(s.next());
        System.out.println(s.hasNext());
        System.out.println(s.next());
        System.out.println(s.hasNext());
        System.out.println(s.next());
        System.out.println(s.hasNext());
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class BSTIterator {
        TreeNode root;
        List<Integer> items = new ArrayList<>();
        int i = 0;

        public BSTIterator(TreeNode root) {
            this.root = root;
            dfs(root);
            Collections.sort(items);
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }

            dfs(node.left);
            items.add(node.val);
            dfs(node.right);
        }

        /** @return the next smallest number */
        public int next() {
            int result = items.get(i);
            i++;
            return result;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return i < items.size();
        }
    }
}
