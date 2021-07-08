package kz.sabyrzhan.algo.data_structures;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    protected NodeWithLeftAndRight head;
    protected NodeWithLeftAndRight tail;
    protected int size = 0;

    public Integer peekFirst() {
        if (head == null) return null;
        return head.getValue();
    }

    public Integer peekLast() {
        if (tail == null) return null;
        return tail.getValue();
    }

    public Integer removeFirst() {
        if (head == null) {
            return null;
        }

        NodeWithLeftAndRight result = head;
        head = head.getRight();
        head.setLeft(null);

        result.setRight(null);
        size--;

        return result.getValue();
    }

    public Integer removeLast() {
        if (tail == null) {
            return null;
        }

        NodeWithLeftAndRight result = tail;
        tail = tail.getLeft();
        tail.setRight(null);

        result.setLeft(null);
        size--;

        return result.getValue();
    }

    public Integer remove(int value) {
        if (head == null || tail == null) return null;
        if (head.getValue() == value) {
            removeFirst();
            return value;
        }

        if (tail.getValue() == value) {
            removeLast();
            return value;
        }

        NodeWithLeftAndRight node = head;
        while(node != null) {
            if (node.getValue() == value) {
                NodeWithLeftAndRight left = node.getLeft();
                NodeWithLeftAndRight right = node.getRight();
                left.setRight(right);
                right.setLeft(left);
                size--;
                return value;
            }
            node = node.getRight();
        }

        return null;
    }

    public Integer removeAtIndex(int index) {
        if (head == null || tail == null) return null;
        if (index == 0) {
            int value = head.getValue();
            removeFirst();
            return value;
        }

        if (index == size - 1) {
            int value = tail.getValue();
            removeLast();
            return value;
        }

        int i = 0;
        NodeWithLeftAndRight node = head;
        while(node != null) {
            if (i == index) {
                NodeWithLeftAndRight left = node.getLeft();
                NodeWithLeftAndRight right = node.getRight();
                left.setRight(right);
                right.setLeft(left);
                size--;
                return node.getValue();
            }
            node = node.getRight();
            i++;
        }

        return null;
    }

    public void addFirst(int value) {
        if (head == null) {
            head = tail = new NodeWithLeftAndRight(value);
        } else {
            NodeWithLeftAndRight node = new NodeWithLeftAndRight(value);
            head.setLeft(node);
            node.setRight(head);
            head = node;
        }
        size++;
    }

    public void addLast(int value) {
        if (head == null) {
            head = tail = new NodeWithLeftAndRight(value);
        } else {
            NodeWithLeftAndRight node = new NodeWithLeftAndRight(value);
            tail.setRight(node);
            node.setLeft(tail);
            tail = node;
        }
        size++;
    }

    public void add(int value) {
        addLast(value);
    }

    public int indexOf(int value) {
        if (head == null || tail == null) {
            return -1;
        }

        int i = 0;
        NodeWithLeftAndRight node = head;
        while(node != null) {
            if (node.getValue() == value) {
                break;
            }
            node = node.getRight();
            i++;
        }

        return i;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private NodeWithLeftAndRight node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Integer next() {
                int value = node.getValue();
                node = node.getRight();
                return value;
            }
        };
    }
}
