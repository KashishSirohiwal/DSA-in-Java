package Binary_Search.LeetCode;

/*
 Problem: Maximum Value at a Given Index in a Bounded Array (LeetCode 1802)

 Idea:
 - We want to maximize nums[index] in an array of length n.
 - Constraint: sum of all elements ≤ maxSum, and each element ≥ 1.
 - To maximize nums[index], other elements should be as small as possible (≥ 1).
 - This is a "Binary Search on Answer Space" problem:
   We search for the largest feasible value of nums[index].

 Technique Used:
 Binary Search on Answer Space

 Steps:
 1. Search space = [1, maxSum - (n-1)].
    - min = 1 (lowest possible value at index).
    - max = maxSum - (n-1) (if all other elements are 1).
 2. While low <= high:
    - mid = candidate value for nums[index].
    - Check feasibility: can we build an array with nums[index] = mid and sum ≤ maxSum?
    - If feasible -> save ans = mid, move right (low = mid+1).
    - Else -> move left (high = mid-1).
 3. Feasibility check:
    - Compute sum of pyramid around index using arithmetic progression.
    - Left side length = index, right side length = n - index - 1.
    - If mid > len -> decreasing sequence stays above 1.
    - Else -> hits 1, fill remaining with ones.
 4. Return ans.

 Time Complexity: O(log(maxSum) + n) -> effectively O(log(maxSum))
 Space Complexity: O(1)
*/

public class MaxValueAtGivenIndexBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1;
        int high = maxSum - (n - 1);
        int ans = 1;

        // Binary search on answer space
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(n, index, maxSum, mid)) {
                ans = mid;       // feasible → try bigger
                low = mid + 1;
            } else {
                high = mid - 1;  // not feasible → try smaller
            }
        }
        return ans;
    }

    // Check if nums[index] = mid is feasible under maxSum
    private boolean isFeasible(int n, int index, int maxSum, int mid) {
        long sum = mid; // value at index itself

        // left side contribution
        int leftLen = index;
        sum += calcSide(mid, leftLen);

        // right side contribution
        int rightLen = n - index - 1;
        sum += calcSide(mid, rightLen);

        return sum <= maxSum;
    }

    // Calculate sum contribution of one side (left or right)
    private long calcSide(int mid, int len) {
        if (mid > len) {

            // Sequence decreases smoothly without hitting 1
            long first = mid - 1;
            long last = mid - len;
            return (first + last) * len / 2;
        } else {

            // Sequence hits 1, fill remaining with ones
            long seqSum = (long)(mid - 1) * mid / 2; // decreasing part
            long ones = len - (mid - 1);             // leftover ones
            return seqSum + ones;
        }
    }
}