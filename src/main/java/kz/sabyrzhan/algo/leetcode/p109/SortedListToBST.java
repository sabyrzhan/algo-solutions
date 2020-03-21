package kz.sabyrzhan.algo.leetcode.p109;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortedListToBST {
    public static void main(String[] args) {
        SortedListToBST p = new SortedListToBST();

        ListNode parent = p.new ListNode(-10);
        int[] a = new int[]{-3,0,5,9};
        ListNode tmp = parent;
        for(int i : a) {
            tmp.next = p.new ListNode(i);
            tmp = tmp.next;
        }

        Solution s = p.new Solution();
        TreeNode result = s.sortedListToBST(parent);
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        private ListNode node;
        public TreeNode sortedListToBST(ListNode head) {
            ListNode runner = head;
            node = head;
            int size = 0;
            while(runner != null) {
                runner = runner.next;
                size++;
            }
            return recurse(0, size - 1);
        }

        private TreeNode recurse(int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = start + (end - start) / 2;
            TreeNode left = recurse(start, mid - 1);

            TreeNode result = new TreeNode(node.val);
            result.left = left;
            node = node.next;

            TreeNode right = recurse(mid + 1, end);
            result.right = right;

            return result;
        }
    }
}
