package kz.sabyrzhan.algo.leetcode.problems.p49;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] a = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams g = new GroupAnagrams();
        Solution s = g.new Solution();
        List<List<String>> result = s.groupAnagrams(a);
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
