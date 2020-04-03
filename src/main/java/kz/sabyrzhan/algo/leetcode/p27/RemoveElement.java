package kz.sabyrzhan.algo.leetcode.p27;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement m = new RemoveElement();
        m.execute();
    }

    private void execute() {
        int[] values = new int[] {2,3,3};
        int val = 2;

        Solution s = new Solution();
        int result = s.removeElement(values, val);
        System.out.println(result);
    }

    class Solution {
        public int removeElement(int[] A, int elem) {
            int m = 0;
            for(int i = 0; i < A.length; i++){

                if(A[i] != elem){
                    A[m] = A[i];
                    m++;
                }
            }

            return m;
        }
    }
}
