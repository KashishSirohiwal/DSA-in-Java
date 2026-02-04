package Recursion.Practice.ReturnBased_Recursion;
import java.util.Scanner;

public class Factorial {
    public static int factorial(int number) {
        // Base Case
        if (number == 0) {
            return 1; // Factorial of 0 is 1
        }
        // Recursive Case
        return number * factorial(number - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
        sc.close();
    }
}
