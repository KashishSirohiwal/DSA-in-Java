package Bubble_Sort.LeetCode;

/*
Problem: Height Checker (LeetCode 1051)

Idea:
- Students should be in non-decreasing order of height.
- Copy the original array into another array.
- Sort the copy using Bubble Sort (manual implementation).
- Compare original vs. sorted array.
- Count how many positions differ.

Technique Used:
- Array copy + Bubble Sort + Comparison.

Time Complexity: O(n^2) (due to bubble sort)
Space Complexity: O(n) (extra array for sorted copy)
*/

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int n = heights.length;

        // Copy original array
        int[] expected = new int[n];
        for (int i = 0; i < n; i++) {
            expected[i] = heights[i];
        }

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (expected[j] > expected[j + 1]) {
                    int temp = expected[j];
                    expected[j] = expected[j + 1];
                    expected[j + 1] = temp;
                }
            }
        }

        // Count mismatches
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        int result = heightChecker(heights);
        System.out.println("Number of students in wrong position: " + result);
    }
}