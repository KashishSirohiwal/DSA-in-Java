package Recursion.Practice.NoReturn_Recursion;

import java.util.Scanner;

public class PrintDigit {
    public static void printDigits(int n) {
        // Base Case
        if (n == 0) {
            return;
        }
        // Recursive Case
        printDigits(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        System.out.print("Digits: ");
        printDigits(n);
        sc.close();
    }
}
