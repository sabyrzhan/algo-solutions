package kz.sabyrzhan.algo.leetcode.problems.p187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (visited.contains(substring)) {
                result.add(substring);
            } else {
                visited.add(substring);
            }
        }

        return new ArrayList<>(result);
    }
}
