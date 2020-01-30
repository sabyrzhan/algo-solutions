package kz.sabyrzhan.algo.aloexpert.easy;

public class T14_CaesarCipher {
    public static void main(String[] args) {
        String str = "xyz";
        int key = 2;
        System.out.println(Program.caesarCypherEncryptor(str, key));
    }

    static class Program {
        public static String caesarCypherEncryptor(String str, int key) {
            StringBuilder stringBuilder = new StringBuilder();
            int sum;
            for(int i = 0; i < str.length(); i++) {
                sum = (str.charAt(i) - 97) + key;
                if(sum > 25) {
                    short x = (short) (sum % 26);
                    stringBuilder.append((char)('a' + x));
                } else {
                    stringBuilder.append((char)(str.charAt(i) + key));
                }
            }

            return stringBuilder.toString();
        }
    }
}
