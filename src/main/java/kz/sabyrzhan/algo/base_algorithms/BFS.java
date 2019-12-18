package kz.sabyrzhan.algo.base_algorithms;

import kz.sabyrzhan.algo.data_structures.NodeWithLeftAndRight;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        NodeWithLeftAndRight root = new NodeWithLeftAndRight(1);
        root.setLeft(new NodeWithLeftAndRight(2));
        root.setRight(new NodeWithLeftAndRight(3));

        root.getLeft().setLeft(new NodeWithLeftAndRight(4));
        root.getLeft().setRight(new NodeWithLeftAndRight(5));

        root.getRight().setLeft(new NodeWithLeftAndRight(6));
        root.getRight().setRight(new NodeWithLeftAndRight(7));

        root.getRight().getLeft().setRight(new NodeWithLeftAndRight(8));

        System.out.println(root);

        int value = identifyLevel(root, 8);
        System.out.println(value);
    }

    public static int search(NodeWithLeftAndRight root, int value) {
        Queue<NodeWithLeftAndRight> queue = new LinkedList<>();
        queue.add(root);
        int result = -1;
        while(!queue.isEmpty()) {
            NodeWithLeftAndRight current = queue.poll();
            if(current.getValue() == value) {
                result = current.getValue();
                break;
            }

            if(current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if(current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return result;
    }

    public static int identifyLevel(NodeWithLeftAndRight root, int forRoot) {
        final NodeWithLeftAndRight DELIMITER = new NodeWithLeftAndRight(-1);
        Queue<NodeWithLeftAndRight> queue = new LinkedList<>();
        queue.add(root);
        queue.add(DELIMITER);
        int level = 0;
        boolean isFound = false;
        while(!queue.isEmpty()) {
            NodeWithLeftAndRight current = queue.poll();
            if(current == DELIMITER) {
                level++;
                if(!queue.isEmpty()) {
                    queue.add(DELIMITER);
                }
                continue;
            }

            if(current.getValue() == forRoot) {
                isFound = true;
                level++;
                break;
            }

            if(current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if(current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return isFound ? level : 0;
    }
}
