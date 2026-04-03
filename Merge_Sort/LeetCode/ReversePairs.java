package Merge_Sort.LeetCode;
    
/*
Problem: Reverse Pairs (LeetCode 493)

Definition:
- Count the number of pairs (i, j) such that:
      i < j and nums[i] > 2 * nums[j]

Example:
- nums = [1, 3, 2, 3, 1]
- Reverse pairs are:
      (3,1) at indices (1,4)
      (3,1) at indices (3,4)
- Answer = 2

------------------------------------------------------------
Idea:
- Brute force checks every pair (i, j), but that takes O(n^2).
- We need a faster way.

- We use Merge Sort because:
  1. It divides the array into two halves.
  2. Recursively solves each half.
  3. While merging, both halves are already sorted.
  4. This sorted property helps us count reverse pairs efficiently.

------------------------------------------------------------
Observation:
- At any merge step, reverse pairs can be of 3 types:

  1. Both elements in left half
  2. Both elements in right half
  3. One element in left half and one in right half (cross-half pair)

- Recursive calls automatically count:
      left-half pairs + right-half pairs

- We only need to manually count:
      cross-half reverse pairs

------------------------------------------------------------
Technique Used:
- Divide and Conquer + Merge Sort

------------------------------------------------------------
Why counting before merge?
- Before merge:
      left half is sorted
      right half is sorted
      and both halves are still separate

- This is the perfect moment to count cross-half reverse pairs.

- After merging:
      boundary between left and right disappears
- So counting must happen BEFORE merge.

------------------------------------------------------------
How cross-half counting works:
- For each element in left half, we want to count how many
  elements in right half satisfy:

      nums[i] > 2 * nums[j]

- Since right half is sorted:
  once a right value stops satisfying the condition,
  all values after it will also fail.

- So we use a pointer j that only moves forward.
- This makes counting efficient.

------------------------------------------------------------
Steps:
1. Divide the array into two halves.
2. Recursively count reverse pairs in left half.
3. Recursively count reverse pairs in right half.
4. Count reverse pairs across left and right halves.
5. Merge the two sorted halves.
6. Return total count.

------------------------------------------------------------
Time Complexity:
- Merge sort has log n levels.
- At each level:
      counting = O(n)
      merging  = O(n)
- Total = O(n log n)

------------------------------------------------------------
Space Complexity:
- Temporary array used during merge = O(n)

-----------------------------------------------------------
Important Note:
- Use long while checking:
      nums[i] > 2 * nums[j]
- Because 2 * nums[j] may overflow for large integers.
*/

public class ReversePairs {

    // Main function: returns total reverse pairs in the array
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Merge Sort function:
    // 1. Divide array into two halves
    // 2. Recursively count reverse pairs in left half
    // 3. Recursively count reverse pairs in right half
    // 4. Count cross-half reverse pairs
    // 5. Merge both halves
    private int mergeSort(int[] nums, int left, int right) {
        // Base case: single element => no pair possible
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        // Count reverse pairs in left half + right half
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count reverse pairs where:
        // first element is in left half
        // second element is in right half
        count += countWhileMerge(nums, left, mid, right);

        // Merge both sorted halves
        merge(nums, left, mid, right);

        return count;
    }

    // Counts cross-half reverse pairs
    private int countWhileMerge(int[] nums, int left, int mid, int right) {
        int count = 0;

        // Pointer for right half
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            // Move j while reverse pair condition is satisfied
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            /*
             Valid right-side elements are from:
                 mid + 1 to j - 1

             So number of valid elements =
                 j - (mid + 1)
            */
            count += (j - (mid + 1));
        }

        return count;
    }

    // Standard merge function of Merge Sort
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = 0;         // pointer for temp array

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];

        while (j <= right) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        ReversePairs solution = new ReversePairs();

        int[] nums1 = {1, 3, 2, 3, 1};
        System.out.println(solution.reversePairs(nums1)); // Output: 2
    }
}