package kz.sabyrzhan.algo.courses.AlgorithmicProblemsInJava.backtracking;

public class SudokuProblem {
    public static void main(String[] args) {
        SudokuProblem s = new SudokuProblem();
        s.execute();
    }
    
    public void execute() {
        Solution s = new Solution();

        int[][] table = new int[][] {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        print(table);
        System.out.println();
        boolean result = s.solve(table);
        System.out.println(result);
        print(table);
    }

    private void print(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public class Solution {
        private boolean[] filledTables = {false,false,false,false,false,false,false,false,false};
        private int[][] table;
        private int[] xCoord = {1,-1, 0, 0};
        private int[] yCoord = {0, 0, 1,-1};

        public boolean solve(int[][] table) {
            this.table = table;
            return solveRecurse(table, 0, 0);
        }

        public boolean solveRecurse(int[][] table, int x, int y) {
            if (x == table.length) {
                y++;
                if (y == table.length) {
                    return true;
                }
            }

            if (x >= table.length) {
                x = 0;
            }

            if (table[x][y] != 0) {
                return solveRecurse(table, x + 1, y);
            }

            for(int k = 1; k <= 9; k++) {
                if (isValid(x,y,table, k)) {
                    table[x][y] = k;
                    if (solveRecurse(table, x, y)) {
                        return true;
                    }
                    table[x][y] = 0;
                }
            }

            return false;
        }

        private boolean isValid(int x, int y, int[][] table, int value) {
            int[] nextCoords = identifySubtableCoords(x, y);
            int nextX = nextCoords[0];
            int nextY = nextCoords[1];

            for(int i = nextX; i < nextX + 3; i++) {
                for(int j = nextY; j < nextY + 3; j++) {
                    if (table[i][j] == value) {
                        return false;
                    }
                }
            }

            for(int i = 0; i < table.length; i++) {
                if (table[i][y] == value) {
                    return false;
                }
            }

            for(int j = 0; j < table.length; j++) {
                if (table[x][j] == value) {
                    return false;
                }
            }

            return true;
        }

        private int[] identifySubtableCoords(int x, int y) {
            int nextX = identifyCoord(x);
            int nextY = identifyCoord(y);

            return new int[] {nextX, nextY};
        }

        private int identifyCoord(int c) {
            int result;
            if (c >= 0 && c <= 2) {
                result = 0;
            } else if(c >= 3 && c <= 5) {
                result = 3;
            } else {
                result = 6;
            }

            return result;
        }

        private boolean isSolved() {
            for(boolean i : filledTables) {
                if (!i) {
                    return false;
                }
            }

            return true;
        }
    }
}
