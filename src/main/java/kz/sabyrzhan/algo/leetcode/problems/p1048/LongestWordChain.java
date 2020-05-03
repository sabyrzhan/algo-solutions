package kz.sabyrzhan.algo.leetcode.problems.p1048;

import java.util.*;

public class LongestWordChain {
    public static void main(String[] args) {
        LongestWordChain p = new LongestWordChain();

       String[] input = new String[] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};

        Solution s = p.new Solution();
        int result = s.longestStrChain(input);
        System.out.println(result);
    }

    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            Map<String, Integer> map = new HashMap<>();
            for(String woro : words) {
                map.put(woro, 1);
            }
            int max = 0;
            for(String word : words) {
                for(int i = 0; i < word.length(); i++) {
                    String prev = word.substring(0, i) + word.substring(i + 1);
                    if (map.containsKey(prev)) {
                        map.put(word, Math.max(map.get(word), map.get(prev) + 1));
                    }
                }
                max = Math.max(max, map.get(word));
            }

            return max;
        }
    }
}
