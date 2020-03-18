package kz.sabyrzhan.algo.leetcode.p63;

public class UniquePaths2 {
    public static void main(String[] args) {
        UniquePaths2 p = new UniquePaths2();

        int[][] arr = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        Solution s = p.new Solution();
        int res = s.uniquePathsWithObstacles(arr);
        System.out.println(res);
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

            for(int i = 0; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                } else {
                    dp[i][0] = 1;
                }
            }

            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                } else {
                    dp[0][j] = 1;
                }
            }

            for(int i = 1; i < obstacleGrid.length; i++) {
                for(int j = 1; j < obstacleGrid[0].length; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }
}
