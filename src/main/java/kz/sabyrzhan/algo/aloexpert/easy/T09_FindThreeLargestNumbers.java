package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.Arrays;

public class T09_FindThreeLargestNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Program.findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
    }

    static class Program {
        public static int[] findThreeLargestNumbers(int[] array) {
            if(array.length == 0 || array.length == 1) {
                return array;
            }

            if(array.length == 2) {
                return array[0] < array[1] ? new int[] {array[1], array[0]} : array;
            }

            int[] result = new int[3];
            result[0] = Integer.MIN_VALUE;
            result[1] = Integer.MIN_VALUE;
            result[2] = Integer.MIN_VALUE;

            for(int i : array) {
                shift(result, i);
            }

            return result;
        }

        private static void shift(int[] result, int value) {
            if(value >= result[2]) {
                result[0] = result[1];
                result[1] = result[2];
                result[2] = value;
            } else if(value >= result[1]) {
                result[0] = result[1];
                result[1] = value;
            } else if(value >= result[0]) {
                result[0] = value;
            }
        }
    }
}
