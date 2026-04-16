package BinarySearch.LeetCode;

/*
 Problem: 1870. Minimum Speed to Arrive on Time

 Statement:
 - You must travel through n train rides.
 - Each ride takes ceil(distance/speed) hours, except the last ride which is exact division.
 - You must arrive within 'hour' hours.
 - Find the minimum integer speed that allows arrival on time, or return -1.

 Idea:
 - Search space = [1, 10^7] (possible speeds).
 - For each mid, simulate travel time:
     * For all rides except last → ceil(dist[i]/mid).
     * For last ride → dist[i]/mid (exact).
 - If total time ≤ hour → feasible, shrink right.
 - Else → increase left.
 - Return smallest feasible speed.

 Technique Used:
 Binary Search on Answer + Simulation feasibility check

 Steps:
 1. low = 1, high = 10^7.
 2. While (low < high):
      mid = (low + high)/2
      If feasible(mid) → high = mid
      Else → low = mid + 1
 3. Return low if feasible, else -1.

 Time Complexity: O(n log(10^7)) ≈ O(n log n)
 Space Complexity: O(1)
*/

public class MinSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = 10000000;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isSpeedFeasible(mid, dist, hour)) {
                high = mid; // shrink right
            } else {
                low = mid + 1;
            }
        }
        return isSpeedFeasible(low, dist, hour) ? low : -1;
    }

    private boolean isSpeedFeasible(int speed, int[] dist, double hour) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                time += (double) dist[i] / speed; // last ride exact
            } else {
                time += Math.ceil((double) dist[i] / speed); // ceil for earlier rides
            }
            if (time > hour) return false; // early exit
        }
        return time <= hour;
    }
}