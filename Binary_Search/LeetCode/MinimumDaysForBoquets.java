package Binary_Search.LeetCode;
    
/*
 Problem: Minimum Number of Days to Make m Bouquets (LeetCode 1482)

 Idea:
 - Each element in bloomDay[] represents the day a flower blooms.
 - A bouquet requires k consecutive bloomed flowers.
 - We need to find the minimum day when at least m bouquets can be formed.
 - If total flowers < m*k → impossible → return -1.

 Technique Used:
 Binary Search on Answer Space

 Steps:
 1. Search space = [min(bloomDay), max(bloomDay)].
 2. While low <= high:
    - mid = candidate day.
    - Check feasibility: can we make ≥ m bouquets by day mid?
    - If feasible → save ans = mid, shrink left (high = mid - 1).
    - Else → move right (low = mid + 1).
 3. Return ans.

 Time Complexity: O(n log(maxDay))
 Space Complexity: O(1)
*/

public class MinimumDaysForBoquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1; // not enough flowers

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int d : bloomDay) {
            low = Math.min(low, d);
            high = Math.max(high, d);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid; // feasible day
                high = mid - 1; // try smaller
            } else {
                low = mid + 1; // need larger day
            }
        }
        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;

        for (int d : bloomDay) {
            if (d <= day) { // flower bloomed
                flowers++;
                if (flowers == k) { // enough consecutive flowers
                    bouquets++;
                    flowers = 0; // reset streak
                }
            } else {
                flowers = 0; // break adjacency
            }
        }
        return bouquets >= m;
    }
}