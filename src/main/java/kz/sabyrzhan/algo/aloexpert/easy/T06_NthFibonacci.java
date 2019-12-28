package kz.sabyrzhan.algo.aloexpert.easy;

public class T06_NthFibonacci {
    public static void main(String[] args) {
        System.out.println(Program.getNthFib(400));
    }

    static class Program {
        public static int getNthFib(int n) {
            if(n < 1) {
                return 0;
            }

            int[] cache = new int[n];
            for(int i = 0; i < n; i++) {
                if(i == 0) {
                    cache[0] = 0;
                } else if(i == 1) {
                    cache[1] = 1;
                } else {
                    cache[i] = cache[i - 1] + cache[i - 2];
                }
            }

            return cache[n - 1];
        }
    }
}
