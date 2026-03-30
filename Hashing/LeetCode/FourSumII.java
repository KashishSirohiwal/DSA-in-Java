package Hashing.LeetCode;
import java.util.*;

/*
Problem: Four Sum II (LeetCode 454)

Idea:
- We want tuples (i, j, k, l) such that A[i] + B[j] + C[k] + D[l] = 0.
- Brute force is O(n^4), too slow.
- Trick: Split into two halves:
    * Compute all sums of A[i] + B[j] and store frequencies in a HashMap.
    * For each sum of C[k] + D[l], check if its negation exists in the map.
- This reduces complexity to O(n^2).

Technique Used:
- HashMap + Meet-in-the-Middle.

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

public class FourSumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Store sums of A and B
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int count = 0;
        
        // For each sum of C and D, check complement
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                count += map.getOrDefault(-sum, 0);
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int result = fourSumCount(A, B, C, D);
        System.out.println("Number of tuples: " + result); 
    }
}