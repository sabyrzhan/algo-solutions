package kz.sabyrzhan.algo.hackerrank.java.data_structures;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    /*
        Input:
            {}()
            ({()})
            {}(
            []
        Output:
            true
            true
            false
            true
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            boolean isBal = isBalanced(input);
            System.out.println(isBal);
        }

        sc.close();
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        int i = 1;
        boolean isValid = false;
        while(i < str.length()) {
            isValid = false;
            if(stack.isEmpty()) {
                stack.push(str.charAt(i));
                i++;
                continue;
            }
            char prev = stack.peek();
            char curr = str.charAt(i);
            if(isOpen(curr)) {
                stack.push(curr);
            } else {
                char nextPair = getNextPair(prev);
                if(nextPair != curr) {
                    break;
                } else {
                    isValid = true;
                    stack.pop();
                }
            }
            i++;
        }

        return stack.isEmpty() ? isValid : false;
    }

    private static boolean isOpen(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    private static char getNextPair(char ch) {
        if(ch == '{') {
            return '}';
        } else if(ch == '[') {
            return ']';
        } else if(ch == '(') {
            return ')';
        } else {
            return 'a';
        }
    }
}
