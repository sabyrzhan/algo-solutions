package kz.sabyrzhan.algo.leetcode.Y2020_April_30_day_challenge;

public class D14_PXXX_PerformStringShifts {
    public static void main(String[] args) {
        D14_PXXX_PerformStringShifts p = new D14_PXXX_PerformStringShifts();
        p.execute();
    }

    private void execute() {
        String str = "abcdefg";
        int[][] shifts = {
                {1,1},
                {1,1},
                {0,2},
                {1,3}
        };

        Solution s = new Solution();
        String result = s.stringShift(str, shifts);
        System.out.println(result);
    }

    class Solution {
        public String stringShift(String s, int[][] shift) {
            int len = s.length();
            for(int[] sh : shift) {
                int i = 0;
                if (sh[0] == 0) {
                    while(i < sh[1]) {
                        s = s + s.charAt(i);
                        i++;
                    }
                    s = s.substring(sh[1]);
                } else {
                    while(i < sh[1]) {
                        s = s.charAt(s.length() - 1 - i) + s;
                        i++;
                    }
                    s = s.substring(0, len);
                }
             }

            return s;
        }
    }
}
