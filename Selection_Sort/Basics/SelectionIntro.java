package Selection_Sort.Basics;

/*
Selection Sort is a comparison-based sorting algorithm that repeatedly selects 
the smallest (or largest, depending on order) element from the unsorted portion of 
the array and places it at its correct position in the sorted portion.

Selection sort partitions into 2 conceptual regions :
1. A sorted portion at the beginning of the array.
2. An unsorted portion that occupies the rest of the array.
and with each iteration, it expands the sorted portion by one element.

How Selection Sort Works:
1. Start with the first element of the array as the current position.
2. Find the smallest element in the unsorted portion of the array.
3. Swap the smallest element found with the element at the current position.
4. Move the current position one step to the right.
5. Repeat steps 2-4 until the entire array is sorted.

Observation : 
- The smallest element of unsorted portion is placed at the correct position in each iteration
- Algorithm works by repeatedly making globally correct local choices, which is a hallmark of greedy algorithms.
- Selection sort unstable as it does not preserve the relative order of equal elements. 

Time Complexity: O(n^2) in all cases (best, average, worst) because of the nested loops.
Space Complexity: O(1) because it is an in-place sorting algorithm that requires only a

*/

public class SelectionIntro {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the minimum is the first element of the unsorted portion

            // Find the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted portion
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}