package kz.sabyrzhan.algo.leetcode.p1138;

import java.util.Collections;
import java.util.List;

public class AlphabetBoardPath {
    public static void main(String[] args) {
        AlphabetBoardPath p = new AlphabetBoardPath();

       String target = "leet";

        Solution s = p.new Solution();
        String result = s.alphabetBoardPath(target);
        System.out.println(result);
    }

    class Solution {
        public String alphabetBoardPath(String target) {
            int x = 0, y = 0;
            StringBuilder sb = new StringBuilder();
            for(char ch : target.toCharArray()) {
                int x1 = (ch - 'a') % 5;
                int y1 = (ch - 'a') / 5;

                List<String> up = Collections.nCopies(Math.max(0, y - y1), "U");
                List<String> right = Collections.nCopies(Math.max(0, x1 - x), "R");
                List<String> left = Collections.nCopies(Math.max(0, x - x1), "L");
                List<String> down = Collections.nCopies(Math.max(0, y1 - y), "D");

                sb.append(String.join("", up) + String.join("", right) +
                        String.join("", left) + String.join("", down) + "!");
                x = x1;
                y = y1;
            }

            return sb.toString();
        }
    }
}
