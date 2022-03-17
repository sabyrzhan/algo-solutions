package kz.sabyrzhan.algo.leetcode.problems.p172;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorialTrailingZeros {
    int countTrailingZeros(int factorialNumber) {
        int count = 0;
        while(factorialNumber > 0) {
            factorialNumber = factorialNumber / 5;
            count += factorialNumber;
        }

        return count;
    }
}
