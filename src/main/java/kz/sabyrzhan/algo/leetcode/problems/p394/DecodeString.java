package kz.sabyrzhan.algo.leetcode.problems.p394;

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder nums = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                nums.append(c);
            } else if (c == '[') {
                stringStack.push(result.toString());
                numStack.push(Integer.valueOf(nums.toString()));
                result = new StringBuilder();
                nums = new StringBuilder();
            } else if (c == ']') {
                int count = numStack.pop();
                StringBuilder lastString = new StringBuilder(stringStack.pop());
                for(int i = 0; i < count; i++) {
                    lastString.append(result);
                }
                result = lastString;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
