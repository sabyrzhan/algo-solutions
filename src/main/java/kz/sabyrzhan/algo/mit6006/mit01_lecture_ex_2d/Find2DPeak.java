package kz.sabyrzhan.algo.mit6006.mit01_lecture_ex_2d;

public class Find2DPeak {
    public static void main(String[] args) {
        int[][] items = new int[][] {
                {27,141,85,429,328,174},
                {195,210,500,22,117,165},
                {466,335,112,54,288,308},
                {155,23,95,167,458,210},
                {2,297,439,212,106,426},
                {395,179,426,211,233,302}
        };

        int globalMax = Integer.MIN_VALUE;
        int globalMaxIndex = -1;
        int n = (items[0].length - 1) / 2;
        while(n >= 0) {
            for(int i = 0; i < items.length; i++) {
                if(items[i][n] >= globalMax) {
                    globalMax = items[i][n];
                    globalMaxIndex = i;
                }
            }

            if(globalMaxIndex < 0 || n == 0 || n > items[0].length - 1) {
                break;
            }

            if(items[globalMaxIndex][n - 1] > globalMax) {
                n = n /2;
            } else if(items[globalMaxIndex][n + 1] > globalMax) {
                n = n + (items[0].length - n - 1);
            } else {
                break;
            }
        }

        System.out.println(globalMax);
    }
}
