package Basics.Questions_Practice;

import java.util.Scanner;

public class PalindromeNumber {
    public static String palindrome(int num) {
        int origianl = num; // Store original
        boolean isNegative = num < 0; // Checks if number is negative
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        if (isNegative) return "is not palindrome" ;
        if (reverse == origianl) return "is palindrome";
        else return "is not palindrome";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        String result = palindrome(num); 
        System.out.println("The number " + num + " " + result);
        sc.close();
    }
}
