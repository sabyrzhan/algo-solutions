package kz.sabyrzhan.algo.leetcode.ArrayAndString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImplementStrStrTest {
    ImplementStrStr impl;

    @BeforeEach
    void setUp() {
        impl = new ImplementStrStr();
    }

    @Test
    public void strStr_findFullString() {
        int index = impl.strStr("hello", "hello");
        assertEquals(0, index);
    }

    @Test
    public void strStr_findSingleChar() {
        int index = impl.strStr("hello", "l");
        assertEquals(2, index);
    }

    @Test
    public void strStr_findLastChar() {
        int index = impl.strStr("hello", "o");
        assertEquals(4, index);
    }

    @Test
    public void strStr_findNonExisting() {
        int index = impl.strStr("hello", "br");
        assertEquals(-1, index);
    }

    @Test
    public void strStr_findEmptySpace() {
        try {
            impl.strStr("hello", "");
        } catch (IllegalArgumentException e) {
            assertEquals("Needle cannot be empty", e.getMessage());
        }
    }

    @Test
    public void strStr_findNullNeedle() {
        try {
            impl.strStr("hello", null);
        } catch (NullPointerException e) {
            assertEquals("Needle cannot be null", e.getMessage());
        }
    }
}
