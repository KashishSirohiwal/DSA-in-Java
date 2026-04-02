package Merge_Sort.LeetCode;

/*
Problem: Sort an Array (LeetCode 912)

Idea:
- Given an array of integers, sort it in ascending order.
- Merge Sort is a divide-and-conquer algorithm:
1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves.

Technique Used: Merge Sort (Divide and Conquer)

- Recursively split the array until single-element subarrays.
- Merge subarrays by comparing elements and building a sorted temporary array.
- Copy the sorted temporary array back into the original array.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class SortAnArray {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return; // base case: single element
        
        int mid = left + (right - left) / 2;
        
        // Recursively sort left half
        mergeSort(nums, left, mid);
        // Recursively sort right half
        mergeSort(nums, mid + 1, right);
        
        // Merge the two halves
        merge(nums, left, mid, right);
    }
    
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        // Merge elements from both halves
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        // Copy remaining elements from left half
        while (i <= mid) temp[k++] = nums[i++];
        // Copy remaining elements from right half
        while (j <= right) temp[k++] = nums[j++];
        
        // Copy sorted temp array back to nums
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.print("Original array : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        sortArray(nums);

        System.out.print("Sorted array : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}