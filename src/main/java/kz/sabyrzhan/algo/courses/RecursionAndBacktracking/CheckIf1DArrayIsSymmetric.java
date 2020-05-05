package kz.sabyrzhan.algo.courses.RecursionAndBacktracking;

public class CheckIf1DArrayIsSymmetric {
    public static void main(String[] args) {
        CheckIf1DArrayIsSymmetric s = new CheckIf1DArrayIsSymmetric();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int[] a = {1,2,2,3};
        System.out.println(s.isSymmetric(a));
    }

    public class Solution {
        public boolean isSymmetric(int[] arr) {
            return isSymmetricRecursive(0, arr.length - 1, arr);
        }

        private boolean isSymmetricIterative(int[] arr) {
            int i = 0;
            int j = arr.length - 1;
            while(i < j) {
                if (arr[i] != arr[j]) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }

        private boolean isSymmetricRecursive(int i, int j, int[] arr) {
            if (i >= j) {
                return true;
            }

            if (arr[i] != arr[j]) {
                return false;
            }

            return isSymmetricRecursive(i + 1, j - 1, arr);
        }
    }
}
