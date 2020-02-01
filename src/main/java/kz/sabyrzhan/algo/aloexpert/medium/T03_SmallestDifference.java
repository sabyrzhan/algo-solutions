package kz.sabyrzhan.algo.aloexpert.medium;

import java.util.Arrays;

public class T03_SmallestDifference {
    public static void main(String[] args) {
        int[] arrayOne = new int[] { -1, 5, 10, 20, 28, 3 };
        int[] arrayTwo = new int[] { 26,134, 135, 15, 17 };
        int[] result = Program.smallestDifference(arrayOne, arrayTwo);
        System.out.println(Arrays.toString(result));
    }

    static class Program {
        public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
            Arrays.sort(arrayOne);
            Arrays.sort(arrayTwo);

            int closest = Integer.MAX_VALUE;
            int closestIndexI= -1, closestIndexJ = -1;
            int i = 0, j = 0;

            while(i < arrayOne.length && j < arrayTwo.length) {
                int a = arrayOne[i];
                int b = arrayTwo[j];
                int diff = Math.abs(a - b);
                if(diff <= closest) {
                    closestIndexI = i;
                    closestIndexJ = j;
                    closest = diff;
                }

                if(a <= b) {
                    i++;
                } else {
                    j++;
                }
            }

            return new int[] { arrayOne[closestIndexI], arrayTwo[closestIndexJ] };
        }
    }
}
