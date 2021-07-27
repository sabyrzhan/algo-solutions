package kz.sabyrzhan.algo.leetcode.problems.p208;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }

    public static class TrieNode {
        public char value;
        private Map<Character, TrieNode> nodes = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(char value) {
            this.value = value;
        }

        public void insert(String str) {
            if (str.length() == 0) {
                nodes.putIfAbsent('.', new TrieNode());
                return;
            }
            nodes.putIfAbsent(str.charAt(0), new TrieNode(str.charAt(0)));
            TrieNode inserted = nodes.get(str.charAt(0));
            inserted.insert(str.substring(1));
        }

        public boolean search(String str) {
            if (str.length() == 0) {
                return nodes.get('.') != null;
            }

            if (nodes.get(str.charAt(0)) == null) {
                return false;
            }

            return nodes.get(str.charAt(0)).search(str.substring(1));
        }

        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) {
                return true;
            }

            if (nodes.get(prefix.charAt(0)) == null) {
                return false;
            }

            return nodes.get(prefix.charAt(0)).startsWith(prefix.substring(1));
        }
    }
}
