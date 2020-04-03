package kz.sabyrzhan.algo.leetcode.p20;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses m = new ValidParentheses();
        m.execute();
    }

    private void execute() {
        String input = "()[]{}";

        Solution solution = new Solution();
        boolean head = solution.isValid(input);
        System.out.println(head);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            Stack<Character> stack = new Stack<>();
            stack.add(s.charAt(0));
            for(int i = 1; i < s.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            }

            return stack.isEmpty();
        }
    }
}
