package Recursion.Basics;

/*
Recursion never works on whole array at once, it always works on index 
that represnt 'how much array is processed till now'.
*/
public class RecursionOnArrays {
    /*
    Base Case: when index reaches array length, it means whole array is processed.
    Recursive Case: process current index and call function for next index.
    */

    public static void printArray(int[] arr, int index) {
        // Base Case
        if (index == arr.length) {
            return; // Whole array is processed
        }
        // Process current index
        System.out.println(arr[index]);
        // Recursive Case
        printArray(arr, index + 1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array elements are:");
        printArray(arr, 0);
    }

    /*
    Recursion Call Stack for printArray with input arr = {1, 2, 3, 4, 5}:
    1. printArray(arr, 0) prints 1 and calls printArray(arr, 1)
    2. printArray(arr, 1) prints 2 and calls printArray(arr, 2)
    3. printArray(arr, 2) prints 3 and calls printArray(arr, 3)
    4. printArray(arr, 3) prints 4 and calls printArray(arr, 4)
    5. printArray(arr, 4) prints 5 and calls printArray(arr, 5)
    6. printArray(arr, 5) hits base case and returns
    7. Stack unwinds and all calls return back to main
    8. Program ends
    */
}
