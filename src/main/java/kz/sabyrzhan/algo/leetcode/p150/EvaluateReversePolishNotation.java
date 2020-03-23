package kz.sabyrzhan.algo.leetcode.p150;

import java.util.*;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation p = new EvaluateReversePolishNotation();

       String[] input = new String[] {
               "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
       };

        Solution s = p.new Solution();
        int result = s.evalRPN(input);
        System.out.println(result);
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();
            ops.put("+", (a,b) -> a +b);
            ops.put("-", (a,b) -> a - b);
            ops.put("*", (a, b) -> a * b);
            ops.put("/", (a,b) -> a / b);
            Stack<Integer> stack = new Stack<>();
            for(String token : tokens) {
                if (ops.get(token) != null) {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    int result = ops.get(token).apply(val1, val2);
                    stack.push(result);
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }

            return stack.pop();
        }
    }
}
