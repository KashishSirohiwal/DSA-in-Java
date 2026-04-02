package Merge_Sort.Basics;

/*
Merge sort is a divide-and-conquer algorithm that breaks down array into smaller 
subarrays until each subarray contains a single element. Then, it merges those 
subarrays back together in a sorted manner.

Merge sort works as follows:
1. Divide the array into two halves until you reach arrays of size one.
2. Merge the subarrays back together in sorted order.

Observations:
- Merge sort is stable (does not change the relative order of equal elements).
- It is not an in-place sorting algorithm (requires additional space for merging).

Time Complexity: O(n log n) - due to the divide and conquer approach.
Space Complexity: O(n) - due to the temporary arrays used during merging.

*/
public class MergeIntro {
    public static void mergeSort(int[] arr, int left, int right) {
        // Base case: if the array has one or zero elements, it's already sorted
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid); // sort left half
        mergeSort(arr, mid + 1, right); // sort right half

        merge(arr, left, mid, right); // merge sorted halves
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // temporary array for merging

        int i = left; // pointer for left subarray
        int j = mid + 1; // pointer for right subarray
        int k = 0; // pointer for temp array

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};

        System.out.print("Original array : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted array : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
