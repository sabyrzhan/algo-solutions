package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.LinkedList;
import java.util.List;

public class D10_P155_MinStack {
    public static void main(String[] args) {
        D10_P155_MinStack p = new D10_P155_MinStack();
        p.execute();
    }

    private void execute() {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(-2);
        s.push(1);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }

    class MinStack {
        private LinkedList<Integer> list = new LinkedList<>();
        private LinkedList<Integer> minList = new LinkedList<>();

        public MinStack() {

        }

        public void push(int x) {
            list.addLast(x);
            if(minList.peekFirst() == null || minList.peekFirst() >= x) {
                minList.addFirst(x);
            } else {
                minList.addLast(x);
            }
        }

        public void pop() {
            if (!list.isEmpty()) {
                int value = list.removeLast();
                if (minList.size() > 0 && minList.getFirst() == value) {
                    minList.removeFirst();
                } else if (minList.size() > 0 && minList.getLast() == value) {
                    minList.removeLast();
                }
            }
        }

        public int top() {
            return list.peekLast() != null ? list.getLast() : 0;
        }

        public int getMin() {
            return minList.peekFirst() != null ? minList.getFirst() : 0;
        }
    }
}
