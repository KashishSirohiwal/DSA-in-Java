package Binary_Search.LeetCode;

/*
 Problem: Peak Index in a Mountain Array (LeetCode 852)

 Idea:
 - A mountain array increases then decreases.
 - The peak is the element greater than both neighbors.
 - Use binary search to find the peak efficiently.

 Technique Used:
 Binary Search on condition (arr[mid] < arr[mid+1])

 Steps:
 1. Initialize low = 0, high = arr.length - 1.
 2. While low < high:
    - Compute mid = low + (high - low) / 2.
    - If arr[mid] < arr[mid+1], peak lies on the right → low = mid + 1.
    - Else peak lies on the left (or at mid) → high = mid.
 3. Return low (or high) → peak index.

 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

public class PeakIndexMountain {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1; // peak is on the right
            } else {
                high = mid; // peak is at mid or on the left
            }
        }
        return low; // or high, both point to peak
    }
}