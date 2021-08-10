package kz.sabyrzhan.algo.leetcode.problems.p884;

import java.util.*;

public class UncommonWordsFromTwoSentences {
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
