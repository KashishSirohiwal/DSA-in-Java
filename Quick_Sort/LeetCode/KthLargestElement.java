package Quick_Sort.LeetCode;

/*
Problem: Kth Largest Element in an Array (LeetCode 215)

Definition:
- Given an integer array nums and an integer k, return the kth largest element in the array.
- Note: It is the kth largest element in sorted order, not the kth distinct element.

Example:
- Input: nums = [3,2,1,5,6,4], k = 2
- Output: 5

Approach:
1. Use Quickselect (based on Quick Sort partitioning).
2. Each partition places the pivot in its correct sorted position.
3. If pivot index == target index, we found the kth largest.
4. Otherwise, recurse only into the half that contains the target.
5. Randomized pivot avoids worst-case O(n^2).
6. Three-way partitioning (Dutch National Flag) handles duplicates efficiently.

Technique Used: Quickselect (Divide and Conquer)

Observations:
- Quickselect is faster than full sorting because it only explores one side of the partition.
- Average time complexity is O(n), worst-case O(n^2) but randomized pivot makes it unlikely.
- Heap-based solutions are also possible (O(n log k)), but Quickselect is more efficient.

Time Complexity:
- Average: O(n)
- Worst-case: O(n^2) (avoided with randomized pivot)

Space Complexity: O(1) (in-place partitioning)
*/

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    private int quickSelect(int[] nums, int low, int high, int targetIndex) {
        while (low <= high) {
            int[] range = partition(nums, low, high);

            int leftBoundary = range[0];
            int rightBoundary = range[1];

            if (targetIndex >= leftBoundary && targetIndex <= rightBoundary) {
                return nums[targetIndex];
            } else if (targetIndex < leftBoundary) {
                high = leftBoundary - 1;
            } else {
                low = rightBoundary + 1;
            }
        }
        return -1; // should not happen
    }

    private int[] partition(int[] nums, int low, int high) {
        int pivotIndex = low + (int)(Math.random() * (high - low + 1));
        int pivot = nums[pivotIndex];

        int lt = low;   // boundary for < pivot
        int i = low;    // current index
        int gt = high;  // boundary for > pivot

        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        return new int[]{lt, gt}; // range of equal elements
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k)); // Output: 5
    }
}