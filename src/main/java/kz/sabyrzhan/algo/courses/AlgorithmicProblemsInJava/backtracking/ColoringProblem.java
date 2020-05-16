package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.util.Arrays;

public class ColoringProblem {
    public static void main(String[] args) {
        ColoringProblem s = new ColoringProblem();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        boolean[][] states = new boolean[][] {
                {false, true, true, true, false, false},
                {true, false, true, false, true, true},
                {true, true, false, true, true, false},
                {true, false, true, false, true, false},
                {false, true, true, true, false, true},
                {false, true, false, false, true, false},
        };

        /*boolean[][] states = new boolean[][] {
                {false, true, false, true, false},
                {true, false, true, true, false},
                {false, true, false, true, false},
                {true, true, true, false, true},
                {false, false, false, true, false}
        };*/



        s.solve(states.length, states);
    }

    public class Solution {

        public void solve(int length, boolean[][] states) {
            int[] colors = new int[length];
            colors[0] = 100;
            int colorsLen = 3;
            boolean result = solve(1, states, colors, colorsLen);
            System.out.println(result);
        }


        // n * n  + n = n^2
        private boolean solve(int position, boolean[][] states, int[] colors, int colorsLen) {
            if (position == states.length) {
                printPath(colors);
                return true;
            }

            for(int i = 0; i < colorsLen; i++) {
                int nextColor = 100 + i;
                if (isValidColor(states, position, nextColor, colors)) {
                    colors[position] = nextColor;
                    if (solve(position + 1, states, colors, colorsLen)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isValidColor(boolean[][] states, int elem, int elemColor, int[] colors) {
            boolean result = true;
            for(int i = 0; i < states.length; i++) {
                if (states[elem][i] && colors[i] == elemColor) {
                    result = false;
                }
            }

            return result;
        }

        private void printPath(int[] path) {
            System.out.println(Arrays.toString(path));
        }
    }
}
