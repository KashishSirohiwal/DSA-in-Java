package Arrays.Kadane_Algo;

/*
Kadane’s Algorithm is an optimization technique used to
solve problems involving contiguous subarrays (or substrings) 
where the objective is to maximize (or sometimes minimize) 
a cumulative function such as sum.
*/

public class KadaneIntro {
    public static void main(String[] args) {
        /*
        At every step, you face a decision:
        1. If your current sum is positive, it helps future elements → you keep it
        2. If your current sum is negative, it harms future elements → you discard it and restart
        
        This is the key idea:
        A negative prefix is useless for a maximum sum subarray.
        */

        /*
        At index i, you define:
        currentSum = max(arr[i], currentSum + arr[i])

        This equation itself captures the entire logic:
        - arr[i] → start fresh from current element
        - currentSum + arr[i] → extend previous subarray

        Then you maintain:
        maxSum = max(maxSum, currentSum)
        
        So:
        - currentSum = best subarray ending at index i
        - maxSum = best subarray found so far
        
        This is dynamic programming because you're building the solution using previous results.
        */

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int currentSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Max : " + maxSum);

        /*
        It embodies a key DP principle:
        “Optimal substructure — best solution at i depends on best solution at i-1”
        */
    }
}
