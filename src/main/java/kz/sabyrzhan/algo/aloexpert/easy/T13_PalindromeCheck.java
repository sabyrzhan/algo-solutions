package kz.sabyrzhan.algo.aloexpert.easy;

public class T13_PalindromeCheck {
    public static void main(String[] args) {
        String str = "abccba";
        boolean result = Program.isPalindrome(str);
        System.out.println(result);
    }

    static class Program {
        public static boolean isPalindrome(String str) {
            boolean isPalindrome = true;
            for(int i = 0, j = str.length() - 1; i <= j; i++, j--) {
                if(str.charAt(i) != str.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
            }

            return isPalindrome;
        }
    }
}
