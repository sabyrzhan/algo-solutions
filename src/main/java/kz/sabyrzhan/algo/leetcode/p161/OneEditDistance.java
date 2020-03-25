package kz.sabyrzhan.algo.leetcode.p161;

// Decription
// https://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
public class OneEditDistance {
    public static void main(String[] args) {
        OneEditDistance p = new OneEditDistance();

       String from = "peaks";
       String to = "geeks";


        Solution s = p.new Solution();
        boolean result = s.editOne(from,to);
        System.out.println(result);
    }

    class Solution {
        public boolean editOne(String from, String to) {
            if (from.length() > to.length()) {
                for(int i = 0; i < (from.length() - to.length()); i++) {
                    to += "*";
                }
            } else {
                for(int i = 0; i < (to.length() - from.length()); i++) {
                    from += "*";
                }
            }

            int changesCount = 0;
            for(int i = 0; i < from.length(); i++) {
                if (changesCount > 1) {
                    break;
                }

                char c1 = from.charAt(i);
                char c2 = to.charAt(i);
                if (c1 != c2) {
                    changesCount++;
                }
            }

            return changesCount == 1;
        }
    }
}
