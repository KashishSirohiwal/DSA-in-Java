package Recursion.Basics;
import java.util.Scanner;

public class RecursionReturn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        printNumbers(number);
        sc.close();
    }
    public static int printNumbers(int number) {
        // Base Case
        if (number == 0) {
            return 0; // Stop the recursion when number reaches 0
        }
        // Print the current number
        System.out.print(number + " ");
        // Recursive Case
        return printNumbers(number - 1); // Call the function with a smaller number
    }

}
