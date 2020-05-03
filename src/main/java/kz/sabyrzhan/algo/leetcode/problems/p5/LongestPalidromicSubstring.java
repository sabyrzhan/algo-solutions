package kz.sabyrzhan.algo.leetcode.problems.p5;

// Explain: https://www.youtube.com/watch?v=y2BD4MJqV20
public class LongestPalidromicSubstring {
    public static void main(String[] args) {
        LongestPalidromicSubstring p = new LongestPalidromicSubstring();

        String input = "babad";

        Solution solution = p.new Solution();
        System.out.println(solution.longestPalindrome(input));
    }

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return s;

            int start = 0;
            int end = 0;

            for(int i = 0; i < s.length(); i++) {
                int len1 = expandFromCenter(s, i, i);
                int len2 = expandFromCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - ((len - 1) / 2);
                    end = i + (len / 2);
                }
            }

            return s.substring(start, end + 1);
        }

        private int expandFromCenter(String s, int left, int right) {
            if (s.length() == 0 || left > right) {
                return 0;
            }

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return right - left - 1;
        }
    }
}