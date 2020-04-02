package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

public class D01_P136_SingleNumber {
    public static void main(String[] args) {
        D01_P136_SingleNumber p = new D01_P136_SingleNumber();
        p.execute();
    }

    private void execute() {
        int[] input = new int[] {2,2,1,5,5,6,6};

        Solution s = new Solution();
        int result = s.singleNumber(input);
        System.out.println(result);
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for(int i : nums) {
                ans ^= i;
            }

            return ans;
        }
    }
}
