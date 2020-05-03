package kz.sabyrzhan.algo.leetcode.problems.p155;

import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {
        MinStack p = new MinStack();
        p.execute();
    }

    private void execute() {
        MinStackSolution s = new MinStackSolution();
        s.push(-2);
        s.push(-2);
        s.push(1);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }

    class MinStackSolution {
        private LinkedList<Integer> list = new LinkedList<>();
        private LinkedList<Integer> minList = new LinkedList<>();

        public MinStackSolution() {

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
