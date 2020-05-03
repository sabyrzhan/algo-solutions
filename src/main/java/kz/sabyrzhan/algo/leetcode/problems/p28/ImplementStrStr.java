package kz.sabyrzhan.algo.leetcode.problems.p28;

public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr m = new ImplementStrStr();
        m.execute();
    }

    private void execute() {
        String str = "mississippi";
        String needle = "issipi";

        Solution s = new Solution();
        int result = s.strStr(str, needle);
        System.out.println(result);
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            for(int i = 0; ; i++) {
                for(int j = 0; ; j++) {
                    if (j == needle.length()) return i;
                    if (i + j == haystack.length()) return -1;
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
            }
        }
    }
}
