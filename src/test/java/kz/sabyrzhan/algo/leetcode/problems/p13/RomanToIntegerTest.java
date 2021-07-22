package kz.sabyrzhan.algo.leetcode.problems.p13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {
    RomanToInteger rom = new RomanToInteger();

    @Test
    public void rom_success() {
        int res = rom.romanToInt("III");
        assertEquals(3, res);
    }

    @Test
    public void rom_success2() {
        int res = rom.romanToInt("IV");
        assertEquals(4, res);
    }

    @Test
    public void rom_success3() {
        int res = rom.romanToInt("IX");
        assertEquals(9, res);
    }

    @Test
    public void rom_success4() {
        int res = rom.romanToInt("LVIII");
        assertEquals(58, res);
    }

    @Test
    public void rom_success5() {
        int res = rom.romanToInt("MCMXCIV");
        assertEquals(1994, res);
    }
}
