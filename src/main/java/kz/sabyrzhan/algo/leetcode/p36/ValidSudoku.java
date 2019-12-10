package kz.sabyrzhan.algo.leetcode.p36;

import java.util.*;
/*
    Store visited column and row in a list of sets
    Store every visited value group in a list of sets
    On every visit check the value for duplicate in a rows, columns and groups list
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] chars = new char[][] {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        ValidSudoku m = new ValidSudoku();
        Solution s = m.new Solution();
        System.out.println(s.isValidSudoku(chars));
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            List<Set<Character>> rows = new ArrayList<>();
            for(int i = 0; i < 9; i++) {
                rows.add(new HashSet<>());
            }
            List<Set<Character>> cols = new ArrayList<>();
            for(int i = 0; i < 9; i++) {
                cols.add(new HashSet<>());
            }

            List<Set<Character>> groups = new ArrayList<>();

            for(int i = 0; i < 9; i++) {
                groups.add(new HashSet<>());
            }

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board.length; j++) {
                    char val = board[i][j];
                    if(val == '.') continue;

                    if(rows.get(i).contains(val)) {
                        return false;
                    }

                    rows.get(i).add(val);

                    if(cols.get(j).contains(val)) {
                        return false;
                    }

                    cols.get(j).add(val);

                    int groupVal = getGroupNumber(i, j);
                    if(groups.get(groupVal).contains(val)) {
                        return false;
                    }

                    groups.get(groupVal).add(val);
                }
            }

            return true;
        }

        private int getGroupNumber(int i, int j) {
            if((i >= 0 && i <= 2) && (j >= 0 && j <= 2)) {
                return 0;
            } else if((i >= 3 && i <= 5) && (j >= 0 && j <= 2)) {
                return 1;
            } else if((i >= 6 && i <= 8) && (j >= 0 && j <= 2)) {
                return 2;
            } else if((i >= 0 && i <= 2) && (j >= 3 && j <= 5)) {
                return 3;
            } else if((i >= 3 && i <= 5) && (j >= 3 && j <= 5)) {
                return 4;
            } else if((i >= 6 && i <= 8) && (j >= 3 && j <= 5)) {
                return 5;
            } else if((i >= 0 && i <= 2) && (j >= 6 && j <= 8)) {
                return 6;
            } else if((i >= 3 && i <= 5) && (j >= 6 && j <= 8)) {
                return 7;
            } else if((i >= 6 && i <= 8) && (j >= 6 && j <= 8)) {
                return 8;
            }

            return -1;
        }
    }
}
