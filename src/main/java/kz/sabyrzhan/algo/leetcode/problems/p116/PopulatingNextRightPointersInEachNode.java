package kz.sabyrzhan.algo.leetcode.problems.p116;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode p = new PopulatingNextRightPointersInEachNode();

        Node parent = p.new Node(1);
        parent.left = p.new Node(2);
        parent.right = p.new Node(3);

        Node left = parent.left;
        left.left = p.new Node(4);
        left.right = p.new Node(5);

        Node right = parent.right;
        right.left = p.new Node(6);
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

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            Node curr = root;
            while(curr != null) {
                Node tmp = curr;
                while(tmp != null) {
                    if (tmp.left != null) {
                        tmp.left.next = tmp.right;
                    }

                    if (tmp.right != null && tmp.next != null) {
                        tmp.right.next = tmp.next.left;
                    }

                    tmp =  tmp.next;
                }
                curr = curr.left;
            }

            return root;
        }
    }
}
