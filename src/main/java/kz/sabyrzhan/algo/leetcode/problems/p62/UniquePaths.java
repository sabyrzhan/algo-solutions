package kz.sabyrzhan.algo.leetcode.problems.p62;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths p = new UniquePaths();

        int m = 7;
        int n = 3;

        Solution s = p.new Solution();
        int res = s.uniquePaths(m,n);
        System.out.println(res);
    }

    class Solution {

        public int uniquePaths(int m, int n) {
            int[][] arr = new int[m][n];
            return bfs(arr, m - 1, n - 1);
        }

        private int bfs(int[][] arr, int m, int n) {
            if (arr[m][n] != 0) {
                return arr[m][n];
            }

            if (m == 0 || n == 0) {
                arr[m][n] = 1;
                return 1;
            } else {
                arr[m][n] = bfs(arr, m - 1, n) + bfs(arr, m, n - 1);
                return arr[m][n];
            }
        }
    }
}
