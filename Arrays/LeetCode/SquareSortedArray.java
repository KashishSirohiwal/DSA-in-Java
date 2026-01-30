package Arrays.LeetCode;
import java.util.Scanner;

/*
 Problem: Squares of a Sorted Array

 Insight:
 - Squaring a sorted array does not preserve order due to negative values.
 - The largest square must come from either end of the array.

 Approach:
 Two Pointer Technique

 - Use two pointers at the start and end of the array.
 - Compare squares at both pointers.
 - Place the larger square at the current end of the result array.
 - Continue until all elements are processed.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class SquareSortedArray {
    public static int[] squareSortedArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // square values
    for (int i = 0; i < n; i++) {
        nums[i] = nums[i] * nums[i];
    }
    int s = 0; // Pointer at start
    int e = n - 1; // Pointer at end
      
    // Place the larger square at current position
    for (int j = n - 1; j >= 0; j--) {
        if (nums[s] > nums[e]) {
            result[j] = nums[s];
            s++;
        } else {
            result[j] = nums[e];
            e--;
        }
    }
    return result;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter element values : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = squareSortedArray(nums);
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        } 
        sc.close();
    }
}
