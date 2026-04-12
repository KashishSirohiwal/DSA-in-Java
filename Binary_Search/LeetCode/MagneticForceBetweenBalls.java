package Binary_Search.LeetCode;
import java.util.*;

/*
 Problem: Magnetic Force Between Two Balls (LeetCode 1552)

 Idea:
 - We have baskets at given positions.
 - We must place m balls such that the minimum distance between any two balls is maximized.
 - To maximize the minimum distance, we use binary search on the possible distance values.

 Technique Used:
 Binary Search on Answer Space

 Steps:
 1. Sort the positions.
 2. Search space = [1, max(position) - min(position)].
 3. While low <= high:
    - mid = candidate distance.
    - Check feasibility: can we place m balls with at least mid spacing?
    - If feasible → save ans = mid, move right (low = mid + 1).
    - Else → move left (high = mid - 1).
 4. Return ans.

 Time Complexity: O(n log(maxDistance))
 Space Complexity: O(1)
*/

public class MagneticForceBetweenBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, m, mid)) {
                ans = mid; // feasible → try bigger
                low = mid + 1;
            } else {
                high = mid - 1; // not feasible → try smaller
            }
        }
        return ans;
    }

    private boolean canPlace(int[] position, int m, int dist) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                count++;
                last = position[i];
                if (count >= m) return true;
            }
        }
        return false;
    }
}