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

        // Method 2: if-else if-else chain
        System.out.println("\n--- Method 2: if-else if-else Chain ---");
        method2_ifElseIfChain(sc);
        
        // Method 3: Nested if-else
        System.out.println("\n--- Method 3: Nested if-else ---");
        method3_nestedIfElse(sc);

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

    /* METHOD 2: if-else if-else Chain */
    public static void method2_ifElseIfChain(Scanner sc) {
        System.out.print("Enter a number (1-5) for grade: ");
        int grade = sc.nextInt();
       
        if (grade == 5) {
            System.out.println("Grade A - Excellent!");
        } else if (grade == 4) {
            System.out.println("Grade B - Good!");
        } else if (grade == 3) {
            System.out.println("Grade C - Average");
        } else if (grade == 2) {
            System.out.println("Grade D - Below Average");
        } else if (grade == 1) {
            System.out.println("Grade F - Failed");
        } else {
            System.out.println("Invalid grade");
        }
    }

    public static void method3_nestedIfElse(Scanner sc) {
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your rank: ");
        int rank = sc.nextInt();

        // Nested 
        if (age >= 18) {
            if (rank >= 65) {
                if (age >=24) {
                    System.out.println("Eligible for premium contest");
                } else {
                    System.out.println("Eligible for standard contest");
                }
            } else {
                System.out.println("Rank incompatible for contest");
            }
        } else {
            System.out.println("Must be 18+ to apply for contest");
        }
    }
}

