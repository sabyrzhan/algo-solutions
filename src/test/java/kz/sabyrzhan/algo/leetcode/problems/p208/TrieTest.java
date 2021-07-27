package kz.sabyrzhan.algo.leetcode.problems.p208;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    Trie trie = new Trie();

    @Test
    public void test() {
        trie.insert("apple");
        assertEquals(true, trie.search("apple"));   // return True
        assertEquals(false, trie.search("app"));     // return False
        assertEquals(true, trie.startsWith("app")); // return True
        trie.insert("app");
        assertEquals(true, trie.search("app"));     // return True
    }
}