package kz.sabyrzhan.algo.base_algorithms;

import kz.sabyrzhan.algo.data_structures.NodeWithLeftAndRight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        NodeWithLeftAndRight root = new NodeWithLeftAndRight(1);
        root.setLeft(new NodeWithLeftAndRight(2));
        root.setRight(new NodeWithLeftAndRight(3));

        root.getLeft().setLeft(new NodeWithLeftAndRight(4));
        root.getLeft().setRight(new NodeWithLeftAndRight(5));

        root.getRight().setLeft(new NodeWithLeftAndRight(6));
        root.getRight().setRight(new NodeWithLeftAndRight(7));

        System.out.println(root);

        int value = search(root, 20);
        System.out.println(value);
    }

    public static int search(NodeWithLeftAndRight root, int value) {
        List<Integer> visited = new ArrayList<>();
        Stack<NodeWithLeftAndRight> stack = new Stack<>();
        stack.push(root);
        int result = -1;
        while(!stack.isEmpty()) {
            NodeWithLeftAndRight current = stack.pop();
            visited.add(current.getValue());
            if(current.getValue() == value) {
                result = current.getValue();
                break;
            }

            if(current.getLeft() != null && !visited.contains(current.getLeft().getValue())) {
                stack.push(current.getLeft());
            }

            if(current.getRight() != null && !visited.contains(current.getRight().getValue())) {
                stack.push(current.getRight());
            }
        }

        return result;
    }
}
