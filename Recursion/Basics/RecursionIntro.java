package Recursion.Basics;

/*
Recursion is a problem-solving technique in which a function solves 
a problem by calling itself on strictly smaller subproblems, and combines
their results to solve the original problem.
*/

public class RecursionIntro {
    /*
    There are two main components of a recursive function:
    1. Base Case: This is the condition under which the function stops calling itself.
        It prevents infinite recursion and eventual stack overflow.
    2. Recursive Case: This is where the function calls itself with a smaller or simpler
        version of the original problem.
    */

    /*
    Execution model of Recursion:
    - Each recursive call is placed on the call stack.
    - Each call has its own set of parameters and local variables.
    - When a base case is reached, the function returns a value to the previous call on the stack.
    - This unwind process continues until all calls have been resolved.
    */
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
    
    public static int factorial(int number) {
        // Base Case
        if (number == 0) {
            return 1; // Factorial of 0 is 1
        }
        // Recursive Case
        return number * factorial(number - 1);
    }

    /*
    The stack trace of the factorial function for input 5 would look like this:
    1. factorial(5) calls factorial(4)
    2. factorial(4) calls factorial(3)
    3. factorial(3) calls factorial(2)
    4. factorial(2) calls factorial(1)
    5. factorial(1) calls factorial(0) & returns 1
    6. now stack unwinds, this happens in reverse order:
        - factorial(1) returns 1 * 1 = 1
        - factorial(2) returns 2 * 1 = 2
        - factorial(3) returns 3 * 2 = 6
        - factorial(4) returns 4 * 6 = 24
        - factorial(5) returns 5 * 24 = 120
    */

    /*
    Why use recursion?
    1. Simplicity: Recursive solutions are often more elegant and easier to understand than iterative ones.
    2. Divide and Conquer: Recursion is a natural fit for problems that can
        be broken down into smaller subproblems, such as sorting algorithms (e.g., quicksort, mergesort).
    3. Backtracking: Recursion is essential for backtracking algorithms, which explore all possible solutions to a problem (e.g., N-Queens problem, Sudoku).
    4. Tree and Graph Traversal: Recursion is commonly used for traversing tree and graph data structures (e.g., depth-first search).
    */
}