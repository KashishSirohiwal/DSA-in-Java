package Quick_Sort.Basics;

/*
Quick sort is sorting algorithm based on the divide and conquer approach. \
It is an efficient sorting algorithm that works by selecting a 'pivot' element 
from the array and partitioning the other elements into two sub-arrays, 
according to whether they are less than or greater than the pivot. 
The sub-arrays are then sorted recursively.

quick sort divides array into 2 parts
1. left part: elements less than pivot
2. right part: elements greater than pivot

The pivot can be chosen in various ways, such as:
1. First element
2. Last element
3. Random element
4. Median element

The efficiency of quick sort depends on the choice of pivot.
- Best and Average Case: O(n log n) when the pivot divides the array into two equal halves.
- Worst Case: O(n^2) when the smallest or largest element is always chosen as the pivot (e.g., when the array is already sorted or reverse sorted).

Observations:
1. Quick sort is an in-place sorting algorithm, meaning it does not require additional space for another array.
2. It is not a stable sorting algorithm, as the relative order of equal elements is not guaranteed to be preserved.
3. Quick sort is widely used in practice due to its efficiency and simplicity, especially for large datasets.

Time Complexity: 
- Best and Average Case: O(n log n)
- Worst Case: O(n^2)

Space Complexity: 
- O(log n) on average when pivot divides the array into two equal halves (due to recursive stack space)
- O(n) when pivot selection is poor (e.g., sorted array)

*/
public class QuickIntro {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partitioning index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing the last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1; // return the partitioning index
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
