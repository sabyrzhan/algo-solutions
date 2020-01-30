package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.Arrays;

public class T12_SelectionSort {
    public static void main(String[] args) {
        int[] ints = new int[] {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(ints));
        int[] result = Program.selectionSort(ints);
        System.out.println(Arrays.toString(result));
    }

    static class Program {
        public static int[] selectionSort(int[] array) {
            int tmp;
            int min;
            int minIndex;
            for(int i = 1; i < array.length; i++) {
                min = array[i - 1];
                minIndex = i - 1;
                for(int j = i; j < array.length; j++) {
                    if(min > array[j]) {
                        System.out.println("Min value: " + min  + " > " + array[j]);
                        min = array[j];
                        minIndex = j;
                    }
                }

                tmp = array[i - 1];
                array[i - 1] = min;
                array[minIndex] = tmp;
                System.out.println(Arrays.toString(array));
            }

            return array;
        }
    }
}
