package Arrays.Basics;
import java.util.Scanner;

/*
Java I/O is essential for DSA problems to read input and 
display output 
*/

public class InputOutput {
    
    public static void main(String[] args) {
        // Initialize Scanner to read from console
        Scanner sc = new Scanner(System.in);
        
        // Example 1: Reading a Integer
        System.out.print("Enter an integer: "); // Input
        int num = sc.nextInt(); 
        System.out.print("You entered: " + num); // Output

        // Example 2: Reading a double
        System.out.print("Enter a decimal number: ");
        double decimal = sc.nextDouble();
        System.out.print("You entered: " + decimal);

        // Always close Scanner to free resources
        sc.close();
    }
}