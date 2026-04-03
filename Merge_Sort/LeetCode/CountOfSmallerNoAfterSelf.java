package Merge_Sort.LeetCode;
import java.util.*;


/*
Problem: Count of Smaller Numbers After Self (LeetCode 315)

Definition:
- Given an integer array nums, return an integer array counts where 
  counts[i] is the number of smaller elements to the right of nums[i].

Example:
- Input: nums = [5, 2, 6, 1]
- Output: [2, 1, 1, 0]

Approach:
1. Use a modified merge sort to count smaller elements to the right.
2. During the merge step, count how many elements from the right half are 
   smaller than the current element from the left half.
3. Store the counts in a result array based on the original indices of the elements.
4. Merge the two halves while maintaining the original order of elements.

Technique Used: Merge Sort (Divide and Conquer)

Observations:
- The merge sort approach allows us to count smaller elements efficiently in O(n log n) time.
- We can use a Pair class to keep track of the original indices of the elements 
  while sorting.
- The counting is done before the merge step, similar to how we count reverse pairs.

Time Complexity: 
  - There are log n levels of recursion due to merge sort.
  - Each merge step takes O(n) time to count and merge.
  - Overall: O(n log n)

Space Complexity: O(n)
*/


public class CountOfSmallerNoAfterSelf {
    private int[] result;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        result = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> ans = new ArrayList<>();
        for (int count : result) {
            ans.add(count);
        }

        return ans;
    }

    private void mergeSort(Pair[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right) {
        Pair[] temp = new Pair[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j].value < arr[i].value) {
                temp[k++] = arr[j++];
                rightCount++;
            } else {
                result[arr[i].index] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            result[arr[i].index] += rightCount;
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNoAfterSelf solution = new CountOfSmallerNoAfterSelf();
        int[] nums = {5, 2, 6, 1};
        System.out.println(solution.countSmaller(nums)); 
    }
}