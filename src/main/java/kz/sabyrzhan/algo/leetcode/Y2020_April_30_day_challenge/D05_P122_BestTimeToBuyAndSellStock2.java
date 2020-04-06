package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

public class D05_P122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        D05_P122_BestTimeToBuyAndSellStock2 p = new D05_P122_BestTimeToBuyAndSellStock2();
        p.execute();
    }

    private void execute() {
        int[] input = {6,1,3,2,4,7};

        Solution s = new Solution();
        int result = s.maxProfit(input);
        System.out.println(result);
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int sum = 0;
            for(int i = 1; i < prices.length; i++) {
                if (prices[i - 1] <= prices[i]) {
                    sum += prices[i] - prices[i -1];
                }
            }

            return sum;
        }

        public int maxProfitWithPeakAndValue(int[] prices) {
            int peak,valley;
            int sum = 0;
            for(int i = 0; i < prices.length; i++) {
                while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                    i++;
                }
                valley = prices[i];
                while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }
                peak = prices[i];
                sum += peak - valley;
            }

            return sum;
        }
    }
}
