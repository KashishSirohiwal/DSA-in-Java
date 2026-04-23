package Recursion.Practice2;

public class IsPalindrome {
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String str = "aba";
        boolean res = isPalindrome(str);
        System.out.println(res);
    }
}