package Quick_Sort.LeetCode;
import java.util.*;

/*
Problem: Top K Frequent Elements (LeetCode 347)

Definition:
- Given an integer array nums and an integer k, return the k most frequent elements.
- You may return the answer in any order.

Example:
- Input: nums = [1,1,1,2,2,3], k = 2
- Output: [1,2]

Approach:
1. Count the frequency of each element using a HashMap.
2. Store the unique elements in an array.
3. Use Quickselect (partition-based selection) to find the k most frequent elements.
   - Partition the array based on frequency.
   - If pivot index == target, we have the k most frequent elements.
   - Otherwise, recurse into the half that contains the kth boundary.
4. Return the top k elements.

Technique Used: Quickselect (Divide and Conquer)

Observations:
- Quickselect avoids sorting the entire array (O(n log n)).
- Average time complexity is O(n), worst-case O(n^2).
- Heap-based solutions are also possible (O(n log k)), but Quickselect is more efficient.

Time Complexity:
- Average: O(n)
- Worst-case: O(n^2) (avoided with randomized pivot)

Space Complexity: O(n) (for frequency map)
*/

public class TopKFrequentElements {
    private Map<Integer, Integer> freq;

    public int[] topKFrequent(int[] nums, int k) {
        freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int n = freq.size();
        int[] unique = new int[n];
        int index = 0;
        for (int num : freq.keySet()) {
            unique[index++] = num;
        }

        int target = n - k;
        quickSelect(unique, 0, n - 1, target);

        return Arrays.copyOfRange(unique, target, n);
    }

    private void quickSelect(int[] unique, int low, int high, int target) {
        if (low >= high) return;

        int pivotIndex = partition(unique, low, high);

        if (pivotIndex == target) return;
        else if (pivotIndex < target) {
            quickSelect(unique, pivotIndex + 1, high, target);
        } else {
            quickSelect(unique, low, pivotIndex - 1, target);
        }
    }

    private int partition(int[] unique, int low, int high) {
        int pivot = unique[high];
        int pivotFreq = freq.get(pivot);

        int i = low;
        for (int j = low; j < high; j++) {
            if (freq.get(unique[j]) <= pivotFreq) {
                swap(unique, i, j);
                i++;
            }
        }
        swap(unique, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k))); // Output: [1,2]
    }
}