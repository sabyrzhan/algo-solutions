package kz.sabyrzhan.algo.aloexpert.easy;

public class T01_TwoSum {
    public int[] twoNumberSum(int[] array, int targetSum) {
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
