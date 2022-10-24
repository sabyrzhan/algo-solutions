package kz.sabyrzhan.algo.leetcode.problems.p58;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWordTest {
    LengthOfLastWord len = new LengthOfLastWord();

    @ParameterizedTest
    @CsvSource({
            "Hello World, 5",
            "   fly me   to   the moon  , 4",
            "luffy is still joyboy, 6"
    })
    void test1(String text, int expectedCount) {
        int r = len.lengthOfLastWord(text);
        assertEquals(expectedCount, r);
    }
}