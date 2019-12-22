package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.Arrays;

public class T01_TwoSum {
    public static void main(String[] args) {
        int[] result = Program.twoNumberSum(new int[] {3,5,-4,8,11,1,-1,6}, 10);
        System.out.println(Arrays.toString(result));
    }

    static class Program {
        public static int[] twoNumberSum(int[] array, int targetSum) {
            int[] result = new int[0];
            for(int i = 0; i < array.length; i++) {
                for(int j = i + 1; j < array.length;j++) {
                    int a = array[i];
                    int b = array[j];
                    if(a + b == targetSum) {
                        result = new int[] {a, b};
                        break;
                    }
                }
            }

            return result;
        }
    }
}
