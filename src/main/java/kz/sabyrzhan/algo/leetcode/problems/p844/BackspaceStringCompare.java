package kz.sabyrzhan.algo.leetcode.problems.p844;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int indexOf;
        while((indexOf = S.indexOf("#")) != -1) {
            S = deleteChars(S, indexOf);
        }

        while((indexOf = T.indexOf("#")) != -1) {
            T = deleteChars(T, indexOf);
        }

        return S.equals(T);
    }

    private String deleteChars(String s, int sharpIndex) {
        if (sharpIndex == 0 && s.length() == 1) {
            s = "";
        } else if(sharpIndex == 0) {
            s = s.substring(1);
        } else {
            s = s.substring(0, sharpIndex - 1) + s.substring(sharpIndex + 1);
        }

        return s;
    }
}
