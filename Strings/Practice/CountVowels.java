package Strings.Practice;

public class CountVowels {
    public static int countVowels(String str) {
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        int result = countVowels(str);
        System.out.println("Count of vowels: " + result);
    }
}
