package kz.sabyrzhan.algo.leetcode.problems.p884;

import java.util.*;

public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        UncommonWordsFromTwoSentences p = new UncommonWordsFromTwoSentences();

       String input = "apple apple";
       String input2 = "banana";

        Solution s = p.new Solution();
        String[] result = s.uncommonFromSentences(input, input2);
        System.out.println(Arrays.toString(result));
    }

    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> counts = new HashMap<>();
            for(String x : (A + " " + B).split(" ")) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            List<String> result = new ArrayList<>();
            for(String w : counts.keySet()) {
                if (counts.get(w) == 1) {
                    result.add(w);
                }
            }

            return result.toArray(new String[result.size()]);
        }
    }
}
