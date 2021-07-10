package kz.sabyrzhan.algo.data_structures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedList;

public class LRU {
    Set<Integer> values = new HashSet<>();
    LinkedList<NodeWithLeftAndRight> cacheValues = new LinkedList<>();
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public NodeWithLeftAndRight get(int value) {
        if (!values.contains(value)) {
            return null;
        } else {
            Iterator<NodeWithLeftAndRight> it = cacheValues.iterator();
            NodeWithLeftAndRight node = null;
            while(it.hasNext()) {
                node = it.next();
                if (node.getValue() == value) {
                    it.remove();
                    cacheValues.addLast(node);
                    break;
                }
            }

            return node;
        }
    }

    public NodeWithLeftAndRight add(int value) {
        NodeWithLeftAndRight node = get(value);
        if (node == null) {
            evictIfNeeded();
            node = new NodeWithLeftAndRight(value);
            cacheValues.addLast(node);
            values.add(value);
        }

        return node;
    }

    private void evictIfNeeded() {
        if (cacheValues.size() >= capacity) {
            NodeWithLeftAndRight node = cacheValues.removeFirst();
            values.remove(node.getValue());
        }
    }
}
