package kz.sabyrzhan.algo.leetcode.problems.p6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {
    ZigZagConversion zig = new ZigZagConversion();

    @Test
    public void zz_success() {
        String s = "PAYPALISHIRING";
        int rows = 3;
        String result = zig.convert(s, rows);
        assertEquals("PAHNAPLSIIGYIR", result);
    }

    @Test
    public void zz_success2() {
        String s = "PAYPALISHIRING";
        int rows = 4;
        String result = zig.convert(s, rows);
        assertEquals("PINALSIGYAHRPI", result);
    }

    @Test
    public void zz_success3() {
        String result = zig.convert("A", 1);
        assertEquals("A", result);
    }

    @Test
    public void zz_success4() {
        String result = zig.convert("A", 2);
        assertEquals("A", result);
    }

    @Test
    public void zz_success5() {
        String result = zig.convert("AB", 2);
        assertEquals("AB", result);
    }

    @Test
    public void zz_success6() {
        String result = zig.convert("AB", 1);
        assertEquals("AB", result);
    }
}
