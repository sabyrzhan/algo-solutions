package kz.sabyrzhan.algo.leetcode.ArrayAndString;

public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr s = new ImplementStrStr();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "o"));
    }

    public class Solution {
        public int strStr(String haystack, String needle) {
            for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                int j = 0;
                while(j < needle.length() && (i + j) < haystack.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }

                if (j == needle.length()) {
                    return i;
                }
            }

            return -1;
        }
    }
}
