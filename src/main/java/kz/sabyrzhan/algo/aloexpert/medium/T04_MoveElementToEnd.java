package kz.sabyrzhan.algo.aloexpert.medium;

import java.util.Arrays;
import java.util.List;

public class T04_MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2,1,2,2,2,3,4,2);
        List<Integer> result = Program.moveElementToEnd(array, 2);
        System.out.println(result);
    }

    static class Program {
        public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
            int i = 0, j = array.size() - 1;
            while(i < j) { // O(n)
                if(array.get(j) == toMove) {
                    j--;
                } else {
                    int tmp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, tmp);
                    i++;
                }
            }

            return array;
        }
    }
}