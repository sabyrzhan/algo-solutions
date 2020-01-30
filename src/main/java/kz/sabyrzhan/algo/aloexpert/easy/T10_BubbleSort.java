package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.Arrays;

public class T10_BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[] {10,2,3,4,6,5};
        int[] result = Program.bubbleSort(ints);
        System.out.println(Arrays.toString(result));
    }

    static class Program {
        public static int[] bubbleSort(int[] array) {
            boolean wasSwapMade;
            int tmp;
            for(int i = array.length - 1; i >= 0; i--) {
                wasSwapMade = false;
                for(int j = 0; j <= i; j++) {
                    if(j == 0) {
                        continue;
                    }

                    if(array[j - 1] > array[j]) {
                        wasSwapMade = true;
                        tmp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = tmp;
                    }
                }

                if(!wasSwapMade) {
                    break;
                }
            }

            return array;
        }
    }
}
