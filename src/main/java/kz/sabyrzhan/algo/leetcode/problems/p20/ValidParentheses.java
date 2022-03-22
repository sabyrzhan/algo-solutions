package kz.sabyrzhan.algo.leetcode.problems.p20;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        var map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(s.charAt(i)) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
