package kz.sabyrzhan.algo.leetcode.problems.p187;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedDNASequencesTest {
    RepeatedDNASequences dna = new RepeatedDNASequences();

    @Test
    void test1() {
        var result = dna.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        Collections.sort(result);
        var expected = Arrays.asList("AAAAACCCCC","CCCCCAAAAA");
        Collections.sort(expected);
        assertEquals(expected, result);
    }

    @Test
    void test2() {
        var result = dna.findRepeatedDnaSequences("AAAAAAAAAAAAA");
        var expected = Arrays.asList("AAAAAAAAAA");
        assertEquals(expected, result);
    }

    @Test
    void test3() {
        var result = dna.findRepeatedDnaSequences("AAAAAAAAAAA");
        var expected = Arrays.asList("AAAAAAAAAA");
        assertEquals(expected, result);
    }
}