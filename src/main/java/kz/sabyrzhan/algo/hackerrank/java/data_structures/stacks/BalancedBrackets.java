package kz.sabyrzhan.algo.hackerrank.java.data_structures.stacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length() % 2 != 0) {
            return "NO";
        }

        if(!isOpen(s.charAt(0))) {
            return "NO";
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;
        while(true) {
            if(i == s.length()) {
                break;
            }

            if(isOpen(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return "NO";
                }

                char prev = stack.peek();
                char nextPair = getNextPair(prev);

                if(nextPair != s.charAt(i)) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }

            i++;
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    static boolean isOpen(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    static char getNextPair(char ch) {
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
