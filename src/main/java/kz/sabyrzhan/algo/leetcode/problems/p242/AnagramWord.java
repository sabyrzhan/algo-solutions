package kz.sabyrzhan.algo.leetcode.problems.p242;

public class AnagramWord {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] occurs = new int[26];

        int charIndex;
        for(int i = 0; i < s.length(); i++) {
            charIndex = s.charAt(i) - 'a';
            occurs[charIndex]++;
        }

        for(int i = 0; i < t.length(); i++) {
            charIndex = t.charAt(i) - 'a';
            occurs[charIndex]--;
            if (occurs[charIndex] < 0) {
                return false;
            }
        }

        return true;
    }
}
