package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

import java.util.*;

public class HamiltonianCycle {
    public static void main(String[] args) {
        HamiltonianCycle s = new HamiltonianCycle();
        s.execute();
    }

    public void execute() {
        Solution s = new Solution();
        /*boolean[][] states = new boolean[][] {
                {false, true, false, false},
                {true,false,true,true},
                {false, true, false, true},
                {true,true,true,false}
        };*/

        boolean[][] states = new boolean[][] {
                {false, true, false},
                {true, false, true},
                {false, true, false}
        };

        boolean hamiltonian = s.isHamiltonian(states.length, states);
        System.out.println(hamiltonian);
    }

    public class Solution {
        private int vertices;
        public boolean isHamiltonian(int vertices, boolean[][] states) {
            this.vertices = vertices;
            int[] path = new int[states.length];
            path[0] = 0;
            return isHamiltonianRecurse(1, states, path);
        }

        private boolean isHamiltonianRecurse(int position, boolean[][] states, int[] path) {
            if (position == vertices) {
                if (states[position - 1][0]) {
                    printPath(path);
                    return true;
                }
                return false;
            }

            for(int i = 1; i < vertices; i++) {
                if (isFisable(position, i, states, path)) {
                    path[position] = i;
                    if (isHamiltonianRecurse(position + 1, states, path)) {
                        return true;
                    }
                }
            }

            return true;
        }

        private void printPath(int[] path) {
            System.out.println(Arrays.toString(path));
        }

        private boolean isFisable(int elem, int vertex, boolean[][] states, int[] path) {
            if (!states[path[elem - 1]][vertex]) {
                return false;
            }

            for(int i = 0; i < elem; i++) {
                if (path[i] == vertex) {
                    return false;
                }
            }

            return true;
        }
    }
}