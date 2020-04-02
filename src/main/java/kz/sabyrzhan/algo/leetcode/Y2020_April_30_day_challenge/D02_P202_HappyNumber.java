package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

import java.util.HashSet;
import java.util.Set;

public class D02_P202_HappyNumber {
    public static void main(String[] args) {
        D02_P202_HappyNumber p = new D02_P202_HappyNumber();
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
