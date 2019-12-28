package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.Arrays;

public class T09_FindThreeLargestNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Program.findThreeLargestNumbers(new int[] {10, 5, 9, 10, 12})));
    }

    static class Program {
        public static int[] findThreeLargestNumbers(int[] array) {
            Arrays.sort(array);
            if(array.length <= 3) {
                return array;
            }

            return new int[] {array[array.length - 3], array[array.length - 2], array[array.length - 1]};
        }
    }
}
