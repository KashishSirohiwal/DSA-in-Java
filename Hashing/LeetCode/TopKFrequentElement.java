package Hashing.LeetCode;
import java.util.*;

/*
Problem: Top K Frequent Elements (LeetCode 347)

Idea:
- Count frequency of each number using HashMap.
- Use a PriorityQueue (max heap) to rank elements by frequency.
- Poll k times to get the top k frequent elements.
- The order of the result does not matter.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/


public class TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
        // Count frequencies using hashmap
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Create max-heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // Add all entries to the heap
        pq.addAll(freq.entrySet());

        // Extract top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.print("Top K frequent elements : ");
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
