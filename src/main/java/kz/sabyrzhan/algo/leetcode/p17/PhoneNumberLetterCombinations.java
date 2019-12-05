package kz.sabyrzhan.algo.leetcode.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234"));
    }

    public static class Solution {
        private Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }

            List<String> result = new ArrayList<>();
            if(digits.length() == 1) {
                String letters = map.get(digits.charAt(0));
                for(char c : letters.toCharArray()) {
                    result.add("" + c);
                }

                return result;
            }


            String firstBlock = map.get(digits.charAt(0));
            for(int i = 0; i < firstBlock.length(); i++) {
                recurse(1, digits, firstBlock.charAt(i) + "", result);
            }

            return result;
        }

        private void recurse(int i, String digits, String prefix, List<String> result) {
            if(i < digits.length()) {
                String letters = map.get(digits.charAt(i));
                for(int j = 0; j < letters.length(); j++) {
                    recurse(i + 1, digits, prefix + letters.charAt(j), result);
                }
            } else {
                result.add(prefix);
            }
        }
    }
}
