package kz.sabyrzhan.algo.leetcode.problems.p13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] roms = {
                'M', 'D', 'C', 'L', 'X', 'V', 'I'
        };

        int[] vals = {
                1000, 500, 100, 50, 10, 5, 1
        };

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < roms.length; i++) {
            map.put(roms[i], vals[i]);
        }

        List<Integer> result = new ArrayList<>();
        result.add(map.get(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > result.get(i - 1)) {
                result.set(i - 1, result.get(i - 1) * -1);
            }
            result.add(map.get(s.charAt(i)));
        }

        int finalResult = result.stream().reduce((a,b) -> a + b).get();
        return finalResult;
    }
}
