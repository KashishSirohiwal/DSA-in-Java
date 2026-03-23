package Arrays.LeetCode.Kadane_LC;

/*
Problem: Maximum Alternating Subsequence Sum (LeetCode 1911)

Idea:
- We want the maximum alternating sum of a subsequence.
- Alternating sum means: sum of elements at even indices - sum of elements at odd indices.
- Example: subsequence [4, 2, 5] → alternating sum = (4 + 5) - 2 = 7.

Technique Used:
- Dynamic Programming (Kadane-style).
- Maintain two states:
    * even → maximum alternating sum if the next element is placed at an even index.
    * odd → maximum alternating sum if the next element is placed at an odd index.
- Transition:
    * even = max(even, odd + num)
    * odd = max(odd, even - num)
- Answer = even (since alternating sum starts with an even index).

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Important Notes:
- even tracks the best alternating sum ending at an even position.
- odd tracks the best alternating sum ending at an odd position.
- At each step, we decide whether to include the current number in even or odd position.
- Final result is stored in even.
*/

class MaxAlternatingSubsequenceSum {
    public static long maxAlternatingSum(int[] nums) {
        long even = 0, odd = 0;
        for (int num : nums) {
            // Update states
            even = Math.max(even, odd + num);
            odd = Math.max(odd, even - num);
        }
        return even;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,5,3};
        long result = maxAlternatingSum(nums);
        System.out.println("Maximum Alternating Subsequence Sum: " + result);
    }
}
