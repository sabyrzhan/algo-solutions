package kz.sabyrzhan.algo.leetcode.problems.p202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber p = new HappyNumber();
        p.execute();
    }

    private void execute() {
        int input = 2;

        Solution s = new Solution();
        boolean result = s.isHappy(input);
        System.out.println(result);
    }

    class Solution {
        public boolean isHappy(int n) {
            int sum = n;
            Set<Integer> sums = new HashSet<>();
            while(sum != 1 && sums.add(sum)) {
                int x = sum;
                sum = 0;
                while(x != 0) {
                    int remain = x % 10;
                    x = x / 10;
                    sum += remain * remain;
                }
            }

            return sum == 1;
        }
    }
}
