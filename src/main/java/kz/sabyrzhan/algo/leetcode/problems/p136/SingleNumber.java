package kz.sabyrzhan.algo.leetcode.problems.p136;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber p = new SingleNumber();

        int[] input = new int[] {2,2,1,5,5,6,6};

        Solution s = p.new Solution();
        int result = s.singleNumber(input);
        System.out.println(result);
    }


    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            System.out.println(ans);
            for(int i : nums) {
                ans ^= i;
                System.out.println(ans);
            }

            return ans;
        }
    }
}
