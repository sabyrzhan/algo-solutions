package kz.sabyrzhan.algo.leetcode.problems.p336;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> items = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            items.put(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        String str1, str2;
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                str1  = words[i].substring(0, j);
                str2 = words[i].substring(j);

                if (isPalindrome(str1)) {
                    String rev = new StringBuilder(str2).reverse().toString();

                    if (items.get(rev) != null && items.get(rev) != i && str1.length() != 0) {
                        result.add(Arrays.asList(items.get(rev), i));
                    }
                }

                if (isPalindrome(str2)) {
                    String rev = new StringBuilder(str1).reverse().toString();
                    if (items.get(rev) != null && items.get(rev) != i) {
                        result.add(Arrays.asList(i, items.get(rev)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        for(int i = 0, j = str.length() - 1; i < str.length() / 2 && j >= str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
