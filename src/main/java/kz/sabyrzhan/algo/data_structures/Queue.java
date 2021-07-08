package kz.sabyrzhan.algo.data_structures;

public class Queue {
    NodeWithLeftAndRight head, tail;
    int size = 0;

    public void add(int value) {
        if (head == null) {
            head = tail = new NodeWithLeftAndRight(value);
        } else {
            NodeWithLeftAndRight node = new NodeWithLeftAndRight(value);
            tail.setRight(node);
            tail = node;
        }
        size++;
    }

    public int poll() {
        if (head == null) {
            throw new RuntimeException("empty queue");
        }
        NodeWithLeftAndRight curr = head;
        head = head.getRight();
        if (head == null) {
            head = tail = null;
        }
        size--;
        return curr.getValue();
    }

    public int peek() {
        if (head == null) {
            throw new RuntimeException("empty queue");
        }

        NodeWithLeftAndRight curr = head;
        return curr.getValue();
    }
}
