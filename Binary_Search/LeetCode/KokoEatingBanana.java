package Binary_Search.LeetCode;

/*
 Problem: Koko Eating Bananas (LeetCode 875)

 Idea:
 - Koko eats bananas at a fixed speed (bananas/hour).
 - Each pile takes ceil(pile/speed) hours.
 - She must finish all piles within h hours.
 - We need the minimum speed that allows her to finish in time.

 Technique Used:
 Binary Search on Answer Space

 Steps:
 1. Search space = [1, max pile size].
 2. While low <= high:
    - Compute mid = candidate speed.
    - Check feasibility: can Koko finish in h hours at speed mid?
    - If feasible → save ans = mid, shrink left (high = mid - 1).
    - Else → move right (low = mid + 1).
 3. Return ans.

 Time Complexity: O(n log m), where n = piles.length, m = max pile size.
 Space Complexity: O(1)
*/

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // max pile size = upper bound of search space
        for (int i : piles) {
            high = Math.max(high, i);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, h, mid)) {
                ans = mid; // feasible speed
                high = mid - 1; // try smaller
            } else {
                low = mid + 1; // need larger
            }
        }
        return ans;
    }

    private boolean canEatAll(int[] piles, int h, int speed) {
        int hrs = 0;
        for (int i : piles) {
            // ceil(i/speed) -> (i + speed - 1)/speed
            hrs += (i + speed - 1) / speed;
        }
        return hrs <= h;
    }
}