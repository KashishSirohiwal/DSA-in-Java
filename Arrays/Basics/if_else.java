package Arrays.Basics;
import java.util.*;

/*
Conditional statements are fundamental for decision-making in programming.
They allow your program to execute different code based on different conditions.
Essential for DSA problems: filtering data, finding patterns, validating inputs
 */
public class if_else {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        // Method 1: Simple if-else
        System.out.println("--- Method 1: Simple if-else ---");
        method1_simpleIfElse(sc);
        
        sc.close();
    }
    
    public static void method1_simpleIfElse(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num > 0) {
            System.out.println(num + " is positive");
        } else if (num < 0) {
            System.out.println(num + " is negative");
        } else {
            System.out.println("Number is zero");
        }
    }
}

