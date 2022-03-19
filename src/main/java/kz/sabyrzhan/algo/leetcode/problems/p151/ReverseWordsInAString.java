package kz.sabyrzhan.algo.leetcode.problems.p151;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
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

        if (startPointer >= endPointer) {
            return "";
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
