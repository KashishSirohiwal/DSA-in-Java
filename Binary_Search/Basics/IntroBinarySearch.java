package Binary_Search.Basics;

/*
Binary Search is a searching algorithm used to efficiently find the position of 
a target element in a sorted data structure (usually a sorted array) by repeatedly 
dividing the search space into two halves and discarding the half in which the 
target cannot possibly exist.

- To apply binary search the search space must be sorted.
- The core idea is : At every step, reduce the possibile search region by half
- For given sorted array, find mid
  - If mid > target : Discard the right half and search in left
  - If mid < target : Discard the left half and search in right
  - If mid = target : Return mid index

Time complexity : O(log n)
Space Complexity : O(1) for iterative, (log n) for recursive version
*/


public class IntroBinarySearch {
    public static int binarySearch(int[] arr, int target) {

        int low = 0; // This marks the left boundary of current search space
        int high = arr.length - 1; // This marks the right boundary of current search space
        
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(arr[mid] == target) {
                return mid;
            }

            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 9, 10, 12, 15, 20, 21};
        int target = 15;
        int x = binarySearch(arr, target);
        System.out.println("Target " + target + " found at index " + x);  
    }
}