package kz.sabyrzhan.algo.data_structures;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack {
    private LinkedList<Object> items;

    public Stack(LinkedList<Object> container) {
        this.items = container;
    }

    public Stack() {
        this.items = new LinkedList<>();
    }

    public Object push(Object elem) {
        items.addLast(elem);
        return elem;
    }

    public Object pop() {
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }

        return items.removeLast();
    }

    public Object peek() {
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }

        return items.getLast();
    }

    public boolean empty() {
        return items.isEmpty();
    }
}
