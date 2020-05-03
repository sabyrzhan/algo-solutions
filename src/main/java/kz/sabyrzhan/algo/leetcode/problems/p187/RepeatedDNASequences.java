package kz.sabyrzhan.algo.leetcode.problems.p187;

import java.util.*;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences p = new RepeatedDNASequences();

       String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        Solution s = p.new Solution();
        List<String> result = s.findRepeatedDnaSequences(input);
        System.out.println(result);
    }

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> doubleWords = new HashSet<>();
            Set<String> repeated = new HashSet<>();
            Map<Character, Integer> chars = new HashMap<>();
            chars.put('A', 0);
            chars.put('C', 1);
            chars.put('G', 2);
            chars.put('T', 3);
            for(int i = 0; i < s.length() - 9; i++) {
                int v = 0;
                for(int j = i; j < i + 10; j++) {
                    v <<= 2;
                    v |= chars.get(s.charAt(j));
                }

                if (visited.contains(v) && !doubleWords.contains(v)) {
                    doubleWords.add(v);
                    repeated.add(s.substring(i, i + 10));
                }

                visited.add(v);
            }

            return new ArrayList<>(repeated);
        }
    }
}
