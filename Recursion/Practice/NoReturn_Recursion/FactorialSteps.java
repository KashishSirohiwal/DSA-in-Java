package Recursion.Practice.NoReturn_Recursion;

public class FactorialSteps {
    public static void factorialSteps(int n) {
        // Base Case
        if (n == 0) {
            System.out.println("Factorial of 0 is 1");
            return;
        }
        // Recursive Case
        System.out.println("Calculating factorial of " + n);
        factorialSteps(n - 1);
        System.out.println("Returning from factorial of " + n);
        System.out.println("Factorial of " + n + " is " + n * factorial(n - 1));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        factorialSteps(n);
    }
}
