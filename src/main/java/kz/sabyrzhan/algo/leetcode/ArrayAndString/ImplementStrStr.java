package kz.sabyrzhan.algo.leetcode.ArrayAndString;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null) {
            throw new NullPointerException("Needle cannot be null");
        }

        if (needle.length() == 0) {
            throw new IllegalArgumentException("Needle cannot be empty");
        }

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
