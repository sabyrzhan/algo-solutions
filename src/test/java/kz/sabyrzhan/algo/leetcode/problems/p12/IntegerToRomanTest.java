package kz.sabyrzhan.algo.leetcode.problems.p12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {
    IntegerToRoman rom = new IntegerToRoman();

    @Test
    public void rom_success() {
        String result = rom.intToRoman(3);
        assertEquals("III", result);
    }

    @Test
    public void rom_success2() {
        String result = rom.intToRoman(4);
        assertEquals("IV", result);
    }

    @Test
    public void rom_success3() {
        String result = rom.intToRoman(9);
        assertEquals("IX", result);
    }

    @Test
    public void rom_success4() {
        String result = rom.intToRoman(58);
        assertEquals("LVIII", result);
    }

    @Test
    public void rom_success5() {
        String result = rom.intToRoman(1994);
        assertEquals("MCMXCIV", result);
    }
}
