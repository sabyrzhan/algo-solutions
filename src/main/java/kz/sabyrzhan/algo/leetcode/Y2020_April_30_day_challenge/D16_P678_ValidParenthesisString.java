package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

//https://leetcode.com/problems/valid-parenthesis-string/discuss/107570/JavaC%2B%2BPython-One-Pass-Count-the-Open-Parenthesis
public class D16_P678_ValidParenthesisString {
    public static void main(String[] args) {
        D16_P678_ValidParenthesisString p = new D16_P678_ValidParenthesisString();
        p.execute();
    }

    private void execute() {
        String inp = "(*)";

        Solution s = new Solution();
        boolean result = s.checkValidString(inp);
        System.out.println(result);
    }

    class Solution {
        public boolean checkValidString(String s) {
            int cmin = 0, cmax = 0;
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    cmax++;
                    cmin++;
                } else if (c == ')') {
                    cmax--;
                    cmin = Math.max(cmin - 1, 0);
                } else {
                    cmax++;
                    cmin = Math.max(cmin - 1, 0);
                }
                if (cmax < 0) return false;
            }
            return cmin == 0;
        }
    }
}
