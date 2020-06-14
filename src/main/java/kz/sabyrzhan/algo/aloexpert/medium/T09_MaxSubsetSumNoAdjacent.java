package kz.sabyrzhan.algo.aloexpert.medium;

public class T09_MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        T09_MaxSubsetSumNoAdjacent s = new T09_MaxSubsetSumNoAdjacent();
        s.execute();
    }
    
    public void execute() {
        int[] array = {75,105,120,75,90,135};
        System.out.println(Program.maxSubsetSumNoAdjacent(array));
    }
    
    public static class Program {
        public static int maxSubsetSumNoAdjacent(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }

            if (array.length == 1) {
                return array[0];
            }

            if (array.length == 2) {
                return Math.max(array[0], array[1]);
            }

            int first = array[0];
            int second = Math.max(array[0], array[1]);
            for(int i = 2; i < array.length; i++) {
                int tmpSecond = second;
                second = Math.max(second, first  + array[i]);
                first = tmpSecond;
            }

            return second;
        }
    }
}