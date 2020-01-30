package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.Arrays;

public class T11_InsertionSort {
    public static void main(String[] args) {
        int[] ints = new int[] {1,2,3,4,5,6};
        int[] result = Program.insertionSort(ints);
        System.out.println(Arrays.toString(result));
    }

    static class Program {
        public static int[] insertionSort(int[] array) {
            int tmp;
            for(int i = 1; i < array.length; i++) {
                for(int j = i; j > 0; j--) {
                    if(array[j - 1] > array[j]) {
                        tmp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = tmp;
                    }
                }
            }

            return array;
        }
    }
}
