package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T07_ProductSum {
    public static void main(String[] args) {
        List<Object> params = new ArrayList<>();
        params.add(5);
        params.add(2);
        params.add(Arrays.asList(7,-1));
        params.add(3);
        params.add(Arrays.asList(6, Arrays.asList(-13,8), 4));
        params.add(Arrays.asList(2,2));
        System.out.println(Program.productSum(params));
    }

    static class Program {
        public static int productSum(List<Object> array) {
            return sumRecursively(array, 0, 1);
        }

        private static int sumRecursively(Object value, int sum, int level) {
            if(value instanceof List) {
                int sumItem = 0;
                for(Object item : (List) value) {
                    sumItem += sumRecursively(item, sum, level + 1);
                }
                sum += sumItem * level;
            } else {
                sum += (Integer) value;
            }

            return sum;
        }
    }
}