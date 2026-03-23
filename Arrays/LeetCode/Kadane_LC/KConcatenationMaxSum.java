package Arrays.LeetCode.Kadane_LC;

/*
Problem: K-Concatenation Maximum Sum (LeetCode 1191)

Idea:
- We want the maximum subarray sum in an array formed by concatenating arr k times.
- Three possible cases:
    1. Subarray lies entirely within one copy => Kadane’s algorithm on arr.
    2. Subarray crosses the boundary between two copies => Kadane’s algorithm on arr+arr.
    3. Subarray spans multiple copies when k > 2 => Best prefix + (k-2)*totalSum + Best suffix.

Technique Used:
- Kadane’s Algorithm for maximum subarray sum.
- Prefix and suffix sums to capture spanning subarrays.
- Total sum to account for middle copies when k > 2.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Important Notes:
- kadane1 = maximum subarray sum in one copy.
- kadane2 = maximum subarray sum in two copies (cross-boundary).
- maxPrefix = best sum starting from the left.
- maxSuffix = best sum starting from the right.
- totalSum = sum of all elements in arr.
- middle = maxPrefix + maxSuffix + (k-2)*totalSum (only relevant if k > 2).
- Final answer = max(kadane1, kadane2, middle), modulo 1e9+7.
*/

class KConcatenationMaxSum {
    public static int kConcatenationMaxSum(int[] arr, int k) {
        long MOD = 1000000007;

        // Case 1: Kadane on single array
        long kadane1 = kadane(arr);
        if (k == 1) return (int)(Math.max(0, kadane1) % MOD);

        // Case 2: Kadane on double array (explicitly build arr+arr)
        int[] doubleArr = new int[arr.length * 2];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = arr[i % arr.length];
        }
        long kadane2 = kadane(doubleArr);

        // Case 3: Compute totalSum, maxPrefix, maxSuffix in one pass
        long prefix = 0, maxPrefix = Long.MIN_VALUE;
        long suffix = 0, maxSuffix = Long.MIN_VALUE;
        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];

            prefix += arr[i];
            maxPrefix = Math.max(maxPrefix, prefix);

            suffix += arr[arr.length - 1 - i];
            maxSuffix = Math.max(maxSuffix, suffix);
        }

        long middle = maxPrefix + maxSuffix + (long)(k - 2) * totalSum;

        // Final result
        long result = Math.max(kadane1, Math.max(kadane2, middle));
        return (int)(Math.max(0, result) % MOD);
    }

    // Standard Kadane’s algorithm
    private static long kadane(int[] arr) {
        long currentSum = arr[0], maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 2};
        int k = 3;
        int result = kConcatenationMaxSum(arr, k);
        System.out.println("K-Concatenation Maximum Sum: " + result);
    }
}