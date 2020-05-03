package kz.sabyrzhan.algo.leetcode.problems.p133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        CloneGraph p = new CloneGraph();

        Node node1 = p.new Node(1, new ArrayList<>());
        Node node2 = p.new Node(2, new ArrayList<>());
        Node node3 = p.new Node(3, new ArrayList<>());
        Node node4 = p.new Node(4, new ArrayList<>());

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node3);
        node2.neighbors.add(node1);

        node3.neighbors.add(node4);
        node3.neighbors.add(node2);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution s = p.new Solution();
        Node result = s.cloneGraph(node1);
        System.out.println(result);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            return dfs(node, new HashMap<>());
        }

        private Node dfs(Node node, Map<Integer, Node> nodes) {
            if (nodes.get(node.val) != null) {
                return nodes.get(node.val);
            }

            Node clone = new Node(node.val, new ArrayList<>());
            nodes.put(node.val, clone);
            for(Node neighb : node.neighbors) {
                Node clonedNeighb = dfs(neighb, nodes);
                clone.neighbors.add(clonedNeighb);
            }

            return clone;
        }
    }
}
