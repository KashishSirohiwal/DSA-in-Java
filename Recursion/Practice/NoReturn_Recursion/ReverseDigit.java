package Recursion.Practice.NoReturn_Recursion;
import java.util.Scanner;

public class ReverseDigit {
    public static void reverseDigits(int n) {
        // Base Case
        if (n == 0) {
            return;
        }
        // Recursive Case
        System.out.print(n % 10 + " ");
        reverseDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        System.out.print("Reversed Digits: ");
        reverseDigits(n);
        sc.close();
    }
}
