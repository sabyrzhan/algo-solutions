package kz.sabyrzhan.algo.leetcode.problems.p8;

import java.util.stream.Stream;

public class StringToInteger {
    public int myAtoi(String str) {
        String[] tokens = str.trim().split(" ");
        Long found = Stream.of(tokens).map(x -> tryParse(x)).filter(x -> x != null).findFirst().orElse(null);
        if (found == null) {
            return 0;
        }

        if (found < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (found > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return found.intValue();
    }

    private Long tryParse(String token) {
        Long result = null;
        try {
            result = Long.parseLong(token);
        } catch (Exception e) {
        }

        return result;
    }
}
