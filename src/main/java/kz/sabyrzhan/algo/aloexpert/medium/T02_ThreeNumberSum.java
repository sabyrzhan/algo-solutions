package kz.sabyrzhan.algo.aloexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T02_ThreeNumberSum {
    public static void main(String[] args) {
        int[] arr = new int[] {12,3,1,2,-6,5,-8,6};
        int target = 0;
        List<Integer[]> result = Program.threeNumberSum(arr, target);
        for(Integer[] tmp : result) {
            System.out.print(Arrays.toString(tmp));
        }
    }

    static class Program {
        public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
            List<Integer[]> result = new ArrayList<>();
            Arrays.sort(array);

            int j, k;
            Integer[] tmp;
            for(int i = 0; i < array.length; i++) {
                j = i + 1;
                k = array.length - 1;
                while(j < k) {
                    int tmpSum = array[i] + array[j] + array[k];
                    if(tmpSum < targetSum) {
                        j++;
                    } else if(tmpSum > targetSum) {
                        k--;
                    } else {
                        tmp = new Integer[] {array[i], array[j], array[k]};
                        Arrays.sort(tmp);
                        result.add(tmp);
                        j++;
                    }
                }
            }

            return result;
        }
    }
}
