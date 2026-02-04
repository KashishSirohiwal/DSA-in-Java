package Recursion.Practice.NoReturn_Recursion;
import java.util.Scanner;

public class PrintNumber {
    public static void oneToN(int n) {
        // Base Case
        if (n == 0) {
            return;
        }
        // Recursive Case
        oneToN(n - 1);
        System.out.print(n + " ");
    }

    public static void nToOne(int n) {
        // Base Case
        if (n == 0) {
            return;
        }
        // Recursive Case
        System.out.print(n + " ");
        nToOne(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        System.out.print("1 to N: ");
        oneToN(n);
        System.out.println();

        System.out.print("N to 1: ");
        nToOne(n);
        sc.close();
    }
}
