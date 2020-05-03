package kz.sabyrzhan.algo.leetcode.problems.p71;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath p = new SimplifyPath();

        String input = "/a/../../b/../c//.//";

        Solution s = p.new Solution();
        String res = s.simplifyPath(input);
        System.out.println(res);
    }

    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            String[] dirs = path.split("/");
            for (String s : dirs) {
                if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    continue;
                }

                if (s.equals(".") || s.length() == 0) {
                    continue;
                }

                stack.push(s);
            }

            String[] paths = new String[stack.size()];
            int i = paths.length - 1;
            while(i >= 0) {
                paths[i] = "/" + stack.pop();
                i--;
            }

            StringBuilder sb = new StringBuilder();
            for(String s : paths) {
                sb.append(s);
            }

            return sb.length() == 0 ? "/" : sb.toString();
        }
    }
}
