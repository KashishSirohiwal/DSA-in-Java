package Arrays.LeetCode;
import java.util.Scanner;

/*
 Problem: Rotate Array (LeetCode - Medium)

 Task:
 Given an integer array nums, rotate the array to the right by k steps.
 The rotation must be done in-place with O(1) extra space.

 Technique Used:
 Reversal Algorithm (Two Pointer Technique)

 Idea:
 Rotating the array to the right by k steps can be done using three reversals:
 1. Reverse the entire array
 2. Reverse the first k elements
 3. Reverse the remaining n - k elements

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class RotateArray {
    // Helper method to reverse a part of the array using two pointers
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    // Main method to rotate the array
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // In case k is greater than array length
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the number of rotations: ");
        int k = sc.nextInt();
        solution.rotate(nums, k);

        // Print rotated array
        System.out.print("Rotated Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}