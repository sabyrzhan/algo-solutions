package kz.sabyrzhan.algo.leetcode.Recursion1.CH5_Conclusion;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        KthSymbolInGrammar s = new KthSymbolInGrammar();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        int N = 4;
        int K = 7;
        System.out.println(s.kthGrammar(N, K));
    }

    public class Solution {
        public int kthGrammar(int N, int K) {
            if (N == 1) {
                return 0;
            }

            if (K % 2 == 0) {
                return kthGrammar(N - 1, K / 2);
            } else {
                return kthGrammar(N - 1, (K + 1) / 2);
            }
        }
    }
}
