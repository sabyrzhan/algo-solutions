package kz.sabyrzhan.algo.leetcode.p20;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses p = new GenerateParentheses();
        Solution s = p.new Solution();
        List<String> result = s.generateParenthesis(3);
        System.out.println(result);
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            int left = n;
            int right = n;

            List<String> result = new ArrayList<>();
            Node initial = new Node(left - 1, right, "(");
            boolean reachedEnd = false;
            Set<String> visited = new HashSet<>();
            Stack<Node> nodes = new Stack<>();
            nodes.push(initial);
            visited.add("(");
            while(true) {
                if(nodes.isEmpty()) {
                    break;
                }

                Node curr = nodes.pop();

                if(reachedEnd) {
                    if(curr.left == 0 || curr.left - curr.right == 0) {
                        continue;
                    }

                    if(!visited.contains(curr.value + "(")) {
                        Node node = new Node(curr.left - 1, curr.right, curr.value + "(");
                        nodes.push(node);
                        visited.add(curr.value + "(");
                        reachedEnd = false;
                        continue;
                    }

                    if(!visited.contains(curr.value + ")")) {
                        Node node = new Node(curr.left, curr.right - 1, curr.value + ")");
                        nodes.push(node);
                        visited.add(curr.value + ")");
                        reachedEnd = false;
                        continue;
                    }
                } else {
                    nodes.push(curr);
                    if(curr.left == 0 && curr.right - 1 == 0) {
                        reachedEnd = true;
                        result.add(curr.value + ")");
                        visited.add(curr.value + ")");
                        nodes.add(new Node(curr.left, curr.right - 1, curr.value + ")"));
                        continue;
                    } else {
                        if(curr.left > 0) {
                            nodes.add(new Node(curr.left - 1, curr.right, curr.value + "("));
                            visited.add(curr.value + "(");
                        } else {
                            nodes.add(new Node(curr.left, curr.right - 1, curr.value + ")"));
                            visited.add(curr.value + ")");
                        }
                    }
                }
            }

            return result;
        }
    }

    public class Node {
        private int left;
        private int right;
        private String value;

        public Node(int left, int right, String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
