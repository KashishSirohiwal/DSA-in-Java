package Merge_Sort.LeetCode;

/*
Problem: Count of Range Sum (LeetCode 327)

Idea:
- We need to count the number of subarrays whose sum lies in [lower, upper].
- Directly checking all subarrays takes O(n^2), which is too slow.

Core Observation:
- Subarray sum from index i to j can be written as:
      prefix[j + 1] - prefix[i]
- So the problem becomes:
      Count how many pairs (i, j) in prefix sum array satisfy:
      lower <= prefix[j] - prefix[i] <= upper

Technique Used: Prefix Sum + Merge Sort (Divide and Conquer)

Steps:
1. Build a prefix sum array.
2. Recursively divide the prefix array into two halves.
3. Count valid range sums:
   - in left half
   - in right half
   - across left and right halves
4. Merge the two sorted halves.

Why Merge Sort?
- During merge step, both halves are sorted.
- This allows us to count valid pairs efficiently using two pointers.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        // Prefix sum array (use long to avoid overflow)
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private static int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) return 0; // base case: single element

        int mid = left + (right - left) / 2;

        // Recursively count in left half
        int countLeft = mergeSort(prefix, left, mid, lower, upper);

        // Recursively count in right half
        int countRight = mergeSort(prefix, mid + 1, right, lower, upper);

        // Count valid pairs across left and right halves
        int countCross = countWhileMerge(prefix, left, mid, right, lower, upper);

        // Merge the two sorted halves
        merge(prefix, left, mid, right);

        return countLeft + countRight + countCross;
    }

    private static int countWhileMerge(long[] prefix, int left, int mid, int right, int lower, int upper) {
        int count = 0;

        int k = mid + 1; // first valid index
        int j = mid + 1; // first invalid index after valid range

        for (int i = left; i <= mid; i++) {
            // Move k until prefix[k] - prefix[i] >= lower
            while (k <= right && prefix[k] - prefix[i] < lower) {
                k++;
            }

            // Move j until prefix[j] - prefix[i] > upper
            while (j <= right && prefix[j] - prefix[i] <= upper) {
                j++;
            }

            // Valid range is [k, j)
            count += (j - k);
        }

        return count;
    }

    private static void merge(long[] prefix, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Merge elements from both halves
        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) temp[k++] = prefix[i++];

        // Copy remaining elements from right half
        while (j <= right) temp[k++] = prefix[j++];

        // Copy sorted temp array back to prefix
        for (int p = 0; p < temp.length; p++) {
            prefix[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;

        System.out.print("Array : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = countRangeSum(nums, lower, upper);

        System.out.println("Lower = " + lower + ", Upper = " + upper);
        System.out.println("Count of Range Sum = " + result);
    }
}