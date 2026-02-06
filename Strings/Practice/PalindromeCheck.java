package Strings.Practice;

import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {       
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        boolean result = isPalindrome(str);
        System.out.println("Is the string a palindrome? " + result);
        sc.close();
    }
}
