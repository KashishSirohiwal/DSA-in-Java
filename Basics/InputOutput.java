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
        System.out.println("You entered: " + num); // Output

        // Example 2: Reading a double
        System.out.print("Enter a decimal number: ");
        double decimal = sc.nextDouble();
        System.out.println("You entered: " + decimal);

        //Example 3: Reading a string (single word)
        System.out.print("Enter a word: ");
        String word = sc.next();
        System.out.println("You entered: " + word);

        // Example 4: Reading entire line (including spaces)
        sc.nextLine(); // Clear the buffer
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.println("You entered: " + sentence);
       
        // Example 5: Reading array of integers
        System.out.print("Enter 5 integers (separated by space): ");
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array: ");
        for (int num1 : arr) {
            System.out.print(num1 + " ");
        }
        System.out.println();

        // Always close Scanner to free resources
        sc.close();
    }
}