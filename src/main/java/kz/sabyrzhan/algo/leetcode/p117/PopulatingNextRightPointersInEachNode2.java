package kz.sabyrzhan.algo.leetcode.p117;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode2 p = new PopulatingNextRightPointersInEachNode2();

        Node parent = p.new Node(1);
        parent.left = p.new Node(2);
        parent.right = p.new Node(3);

        Node left = parent.left;
        left.left = p.new Node(4);
        left.right = p.new Node(5);

        Node right = parent.right;
        right.right = p.new Node(7);

        Solution s = p.new Solution();
        Node result = s.connect(parent);
        System.out.println(result);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    class Solution {
        public Node connect(Node root) {
            Node parent = root;
            Node dummyHead = new Node(0);
            Node pre = dummyHead;
            while (root != null) {
                if (root.left != null) {
                    pre.next = root.left;
                    pre = pre.next;
                }
                if (root.right != null) {
                    pre.next = root.right;
                    pre = pre.next;
                }
                root = root.next;
                if (root == null) {
                    pre = dummyHead;
                    root = dummyHead.next;
                    dummyHead.next = null;
                }
            }

            return parent;
        }
    }
}
