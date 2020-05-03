package kz.sabyrzhan.algo.leetcode.problems.p186;

import java.util.Arrays;

// https://www.lintcode.com/problem/reverse-words-in-a-string-ii/description
public class ReverseWordsInString2 {
    public static void main(String[] args) {
        ReverseWordsInString2 p = new ReverseWordsInString2();

       String str = "a b c";
       char[] input = str.toCharArray();

        Solution s = p.new Solution();
        char[] result = s.reverseWords(input);
        System.out.println(Arrays.toString(result));
    }

    public class Solution {
        /**
         * @param str: a string
         * @return: return a string
         */
        public char[] reverseWords(char[] str) {
            if (str == null) {
                return null;
            }
            for(int i = 0, j = str.length - 1; i < str.length / 2 && j >=str.length / 2; i++, j--) {
                char tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }

            int lastSpaceIndex = -1;
            int startIndex = 0;
            for(int i = 0; i < str.length; i++) {
                if (str[i] == ' ') {
                    reverseWords(str, startIndex, i - 1);
                    startIndex = i + 1;
                    lastSpaceIndex = i;
                }
            }

            if (lastSpaceIndex != -1) {
                reverseWords(str, lastSpaceIndex + 1, str.length - 1);
            } else {
                reverseWords(str, 0, str.length - 1);
            }

            return str;
        }

        private void reverseWords(char[] chars, int startIndex, int endIndex) {
            for(;startIndex <= endIndex; startIndex++, endIndex--) {
                char tmp = chars[startIndex];
                chars[startIndex] = chars[endIndex];
                chars[endIndex] = tmp;
            }
        }
    }
}
