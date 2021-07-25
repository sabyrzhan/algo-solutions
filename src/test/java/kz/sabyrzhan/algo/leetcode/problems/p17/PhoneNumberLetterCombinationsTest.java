package kz.sabyrzhan.algo.leetcode.problems.p17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberLetterCombinationsTest {
    PhoneNumberLetterCombinations com = new PhoneNumberLetterCombinations();

    @Test
    public void com_success() {
        List<String> strings = com.letterCombinations("23");
        assertEquals(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"), strings);
    }

    @Test
    public void com_success2() {
        List<String> strings = com.letterCombinations("");
        assertEquals(Arrays.asList(), strings);
    }

    @Test
    public void com_success3() {
        List<String> strings = com.letterCombinations("2");
        assertEquals(Arrays.asList("a","b","c"), strings);
    }
}
