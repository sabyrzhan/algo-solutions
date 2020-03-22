package kz.sabyrzhan.algo.leetcode.p127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder p = new WordLadder();

        String begin = "hit";
        String end = "cog";
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");

        Solution s = p.new Solution();
        int result = s.ladderLength(begin, end, words);
        System.out.println(result);
    }

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            return ladderLength(beginWord, endWord, new HashSet<>(wordList));
        }

        public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
            Set<String> reached = new HashSet<String>();
            reached.add(beginWord);
            wordDict.add(endWord);
            int distance = 1;
            while (!reached.contains(endWord)) {
                Set<String> toAdd = new HashSet<String>();
                for (String each : reached) {
                    for (int i = 0; i < each.length(); i++) {
                        char[] chars = each.toCharArray();
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            chars[i] = ch;
                            String word = new String(chars);
                            if (wordDict.contains(word)) {
                                toAdd.add(word);
                                wordDict.remove(word);
                            }
                        }
                    }
                }
                distance++;
                if (toAdd.size() == 0) return 0;
                reached = toAdd;
            }
            return distance;
        }
    }
}
