package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.*;

public class D06_P49_GroupAnagrams {
    public static void main(String[] args) {
        D06_P49_GroupAnagrams p = new D06_P49_GroupAnagrams();
        p.execute();
    }

    private void execute() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution s = new Solution();
        List<List<String>> result = s.groupAnagrams(input);
        System.out.println(result);
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> items = new HashMap<>();
            for (String str: strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (items.get(key) == null) {
                    items.put(key, new ArrayList<>());
                }
                items.get(key).add(str);
            }

            List<List<String>> result = new ArrayList<>();
            for(String key : items.keySet()) {
                result.add(items.get(key));
            }

            return result;
        }
    }
}
