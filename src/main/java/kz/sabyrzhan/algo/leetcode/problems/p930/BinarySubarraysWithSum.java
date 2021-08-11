package kz.sabyrzhan.algo.leetcode.problems.p930;

public class BinarySubarraysWithSum {
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
