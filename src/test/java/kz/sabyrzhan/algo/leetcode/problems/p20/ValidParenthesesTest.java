package kz.sabyrzhan.algo.leetcode.problems.p20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    ValidParentheses par = new ValidParentheses();

    @Test
    void test0() {
        String s = "";
        assertTrue(par.isValid(s));
    }

    @Test
    void test1() {
        String s = "(";
        assertFalse(par.isValid(s));
    }

    @Test
    void test3() {
        String s = "()";
        assertTrue(par.isValid(s));
    }

    @Test
    void test4() {
        String s = "{()}(){}";
        assertTrue(par.isValid(s));
    }

    @Test
    void test5() {
        String s = "(){}}{";
        assertFalse(par.isValid(s));
    }
}