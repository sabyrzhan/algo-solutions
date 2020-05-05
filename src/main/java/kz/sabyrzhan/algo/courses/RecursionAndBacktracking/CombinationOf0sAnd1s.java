package kz.sabyrzhan.algo.courses.RecursionAndBacktracking;

import java.util.Arrays;

public class CombinationOf0sAnd1s {
    public static void main(String[] args) {
        CombinationOf0sAnd1s s = new CombinationOf0sAnd1s();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int[] a = new int[4];
        s.printCombinations(0, a);
    }

    public class Solution {
        public void printCombinations(int i, int[] arr) {
            if (i == arr.length) {
                System.out.println(Arrays.toString(arr));
                return;
            }

            arr[i] = 0;
            printCombinations(i + 1, arr);
            arr[i] = 1;
            printCombinations(i + 1, arr);
            arr[i] = 0;
        }
    }
}
