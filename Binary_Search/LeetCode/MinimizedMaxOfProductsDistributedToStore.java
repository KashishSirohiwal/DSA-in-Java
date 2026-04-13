package Binary_Search.LeetCode;
    
/*
 Problem: 2064. Minimized Maximum of Products Distributed to Any Store

 Statement:
 - We have n stores and quantities[] where quantities[i] = number of products of type i.
 - Each store can only hold one product type (but multiple units of it).
 - Goal: minimize the maximum number of products any store receives.

 Idea:
 - Answer lies between [1, max(quantities)].
 - Binary Search on Answer Space:
   * mid = candidate maximum load per store.
   * Check feasibility: can we distribute all products so that no store has > mid items?
   * If feasible → try smaller (high = mid - 1).
   * If not feasible → try larger (low = mid + 1).

 Technique Used:
 Binary Search + Greedy Feasibility Check

 Feasibility Function:
 - For each product type q:
   storesNeeded += ceil(q / mid)
 - If total storesNeeded ≤ n → feasible
 - Else → not feasible

 Steps:
 1. Initialize low = 1, high = max(quantities).
 2. Binary search between low and high.
 3. Use isFeasible() to check if mid works.
 4. Update answer accordingly.
 5. Return minimized maximum.

 Time Complexity: O(m log(max(quantities))) 
   where m = quantities.length
 Space Complexity: O(1)
*/

public class MinimizedMaxOfProductsDistributedToStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for (int q : quantities) {
            high = Math.max(high, q);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(n, quantities, mid)) {
                ans = mid;       // feasible -> try smaller
                high = mid - 1;
            } else {
                low = mid + 1;   // not feasible -> try larger
            }
        }
        return ans;
    }

    private boolean isFeasible(int n, int[] quantities, int mid) {
        int storeNeed = 0;
        for (int q : quantities) {
            storeNeed += (int)Math.ceil((double)q / mid);
            if (storeNeed > n) return false; // early exit
        }
        return storeNeed <= n;
    }
}
