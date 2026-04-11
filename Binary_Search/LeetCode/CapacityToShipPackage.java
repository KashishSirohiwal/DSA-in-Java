package Binary_Search.LeetCode;
    
/*
 Problem: Capacity To Ship Packages Within D Days (LeetCode 1011)

 Idea:
 - Packages must be shipped in order.
 - Each day, load packages until capacity is exceeded, then start a new day.
 - Minimum capacity = max(weights) (must carry heaviest package).
 - Maximum capacity = sum(weights) (carry all in one day).
 - Use binary search to find the minimum feasible capacity.

 Technique Used:
 Binary Search on Answer Space

 Steps:
 1. Initialize low = max(weights), high = sum(weights).
 2. While low <= high:
    - mid = candidate capacity.
    - Check feasibility: can we ship in ≤ days with capacity mid?
    - If feasible → save ans = mid, shrink left (high = mid - 1).
    - Else → move right (low = mid + 1).
 3. Return ans.

 Time Complexity: O(n log(sum(weights)))
 Space Complexity: O(1)
*/

public class CapacityToShipPackage {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // Define search space
        for (int w : weights) {
            low = Math.max(low, w); // must carry heaviest package
            high += w; // sum of all packages
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid; // feasible capacity
                high = mid - 1; // try smaller
            } else {
                low = mid + 1; // need larger
            }
        }
        return ans;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1, currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                usedDays++; // start new day
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return usedDays <= days;
    }
}