package Recursion.Practice2;

public class CountVowels {
    public static int countVowels(String str, int i) {
        if (i == str.length()) return 0;
        
        char c = Character.toLowerCase(s.charAt(i));
        int isVowel = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        
        return countV + countVowels(str, i+1);
    }

    public static void main(String[] args) {
        String str = "Kashish";
        int res = countVowels(String str, 0);
        System.out.println(res);
    }
}