package kz.sabyrzhan.algo.leetcode.p17;

import java.util.*;

public class PhoneNumberLetterCombinations {
    public static void main(String[] args) {
        PhoneNumberLetterCombinations p = new PhoneNumberLetterCombinations();

        Solution solution = p.new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    class Solution {
        private Map<Character, String> map = new HashMap<>();

        public Solution() {
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }

            List<String> result = new ArrayList<>();
            recurse("", result, digits, 0);

            return result;
        }

        private void recurse(String prefix, List<String> results, String digits, int i) {
            if (i == digits.length()) {
                results.add(prefix);
                return;
            }

            String letters = map.get(digits.charAt(i));
            for(int j = 0; j < letters.length(); j++) {
                recurse(prefix + letters.charAt(j), results, digits, i + 1);
            }
        }
    }
}
