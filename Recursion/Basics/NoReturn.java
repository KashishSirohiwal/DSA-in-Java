package Recursion.Basics;
import java.util.Scanner;
public class NoReturn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        System.out.println("Printing numbers from " + number + " down to 1:");
        printNumbers(number);
        sc.close();
    }

    public static void printNumbers(int number) {
        // Base Case
        if (number == 0) {
            return; // Stop the recursion when number reaches 0
        }
        // Print the current number
        System.out.print(number + " ");
        // Recursive Case
        printNumbers(number - 1); // Call the function with a smaller number
    }
}
