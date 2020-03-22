package kz.sabyrzhan.algo.leetcode.p138;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        CopyListWithRandomPointer p = new CopyListWithRandomPointer();

        Node node1 = p.new Node(1);
        Node node2 = p.new Node(2);

        node1.next = node2;
        node1.random = node2;

        node2.next = null;
        node2.random = node2;

        Solution s = p.new Solution();
        Node result = s.copyRandomList(node1);
        System.out.println(result);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            //return dfs(head, new HashMap<>());
            Map<Node, Node> nodes = new HashMap<>();
            Node tmp = head;
            while(tmp != null) {
                nodes.put(tmp, new Node(tmp.val));
                tmp = tmp.next;
            }

            tmp = head;
            while(tmp != null) {
                nodes.get(tmp).next = nodes.get(tmp.next);
                nodes.get(tmp).random = nodes.get(tmp.random);
                tmp = tmp.next;
            }

            return nodes.get(head);
        }

        public Node dfs(Node node, Map<Node, Node> visitedNodes) {
            if (node == null) {
                return null;
            }

            if (visitedNodes.get(node) != null) {
                return visitedNodes.get(node);
            }

            Node clone = new Node(node.val);
            visitedNodes.put(node, clone);
            clone.next = dfs(node.next, visitedNodes);
            clone.random = dfs(node.random, visitedNodes);

            return clone;
        }
    }
}
