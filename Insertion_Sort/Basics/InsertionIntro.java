package Insertion_Sort.Basics;

/*
Insertion Sort is a comparison-based sorting algorithm that builds the sorted array 
gradually, one element at a time, by taking each element from the unsorted portion 
and inserting it into its correct position in the already sorted portion.

Insertion sort maintains two conceptual regions in the array:
1. A sorted portion at the beginning of the array.
2. An unsorted portion that occupies the rest of the array.
With each iteration, it takes the first element from the unsorted portion and inserts 
it into the correct position in the sorted portion.

So unlike Bubble Sort (which swaps repeatedly) and Selection Sort (which selects minimum), 
Insertion Sort focuses on:
“Take current element and insert it where it truly belongs.”

How Insertion Sort Works:
1. Start with the second element of the array (index 1) as the current position
2. Store the current element (key) and compare it with the elements in the sorted portion to its left.
3. Shift elements in the sorted portion that are greater than the key to one position to the right.
4. Insert the key at its correct position in the sorted portion.
5. Move to the next element in the unsorted portion and repeat steps 2-4 until the entire array is sorted.

Observation:
- It is stable sorting algorithm as it preserves the relative order of equal elements.
- It is in-place sorting algorithm as it requires only a constant amount of additional space.

Time Complexity: O(n^2) in the worst and average cases due to the nested loops, 
                 but O(n) in the best case when the array is already sorted.
Space Complexity: O(1) because it is an in-place sorting algorithm 
*/

public class InsertionIntro {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The current element to be inserted
            int j = i - 1; // The last index of the sorted portion

            // Move elements of the sorted portion that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift element to the right
                j--; // Move left in the sorted portion
            }
            arr[j + 1] = key; // Insert the key at its correct position
        }

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}