package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColoringProblem {
    public static void main(String[] args) {
        ColoringProblem s = new ColoringProblem();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        boolean[][] states = new boolean[][] {
                {false, true, false},
                {true, false, true},
                {false, true, false}
        };

        s.solve(states.length, states);
    }

    public class Solution {

        public void solve(int length, boolean[][] states) {
            int[][] colors = new int[length][length];
        }

        private boolean solve(int position, boolean[][] states, int[] path, int[][] colors) {
            if (position == states.length) {
                int[] adjColors = getAdjsColors(position - 1, states, colors);
                int nextColor;
                if (adjColors.length != 0) {
                    nextColor = adjColors[adjColors.length - 1] + 1;
                } else {
                    nextColor = 100;
                }
                colors[position - 1][]
            }
        }

        private int[] getAdjsColors(int elem, boolean[][] states, int[][] colors) {
            List<Integer> values = new ArrayList<>();
            for(int i = 0; i < states.length; i++) {
                if (states[elem][i] && colors[elem][i] != 0) {
                    values.add(colors[elem][i]);
                }
            }

            Collections.sort(values);

            return values.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
