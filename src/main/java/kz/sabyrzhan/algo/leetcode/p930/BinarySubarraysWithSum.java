package kz.sabyrzhan.algo.leetcode.p930;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        BinarySubarraysWithSum p = new BinarySubarraysWithSum();

       int[] input = new int[] {
               1,0,1,0,1
       };

       int k = 2;

        Solution s = p.new Solution();
        int result = s.numSubarraysWithSum(input, k);
        System.out.println(result);
    }

    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            int totalSum = 0;
            int result = 0;
            int[] count = new int[A.length + 1];
            count[0] = 1;
            for(int i : A) {
                totalSum += i;
                if (totalSum >= S) {
                    result += count[totalSum - S];
                }
                count[totalSum]++;
            }

            return result;
        }
    }
}
