package kz.sabyrzhan.algo.base_algorithms;

import kz.sabyrzhan.algo.data_structures.NodeWithLeftAndRight;

import java.util.*;

public class BFS {
    public static List<Integer> visitAll(NodeWithLeftAndRight root) {
        Map<NodeWithLeftAndRight, Boolean> visited = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        Queue<NodeWithLeftAndRight> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            var node = queue.poll();
            if (!visited.containsKey(node)) {
                visited.put(root, true);
                values.add(node.getValue());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }

        return values;
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
