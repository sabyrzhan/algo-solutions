package kz.sabyrzhan.algo.leetcode.p151;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        ReverseWordsInAString p = new ReverseWordsInAString();

       String input = "  hello world!  ";

        Solution s = p.new Solution();
        String result = s.reverseWords(input);
        System.out.println(result);
    }

    class Solution {
        public String reverseWords(String s) {
            boolean onlySpaces = true;
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    onlySpaces = false;
                    break;
                }
            }

            if (onlySpaces) {
                return "";
            }

            int startPointer = 0;
            int endPointer = s.length() - 1;
            while(startPointer < endPointer && (s.charAt(startPointer) == ' ' || s.charAt(endPointer) == ' ')) {
                if (s.charAt(startPointer) == ' ') {
                    startPointer++;
                }

                if (s.charAt(endPointer) == ' ') {
                    endPointer--;
                }
            }

            boolean spaceAdded = false;
            String result = "";
            String tmp = "";
            for(int i = endPointer; i >= startPointer; i--) {
                if (s.charAt(i) == ' ') {
                    if (!spaceAdded) {
                        result += tmp + " ";
                        tmp = "";
                        spaceAdded = true;
                    }
                    continue;
                }

                tmp = s.charAt(i) + tmp;
                spaceAdded = false;
            }

            result += tmp;

            return result;
        }
    }
}
