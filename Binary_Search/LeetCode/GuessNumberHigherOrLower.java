package Binary_Search.LeetCode;

/*
 Problem: Guess Number Higher or Lower (LeetCode 374)

 Idea:
 - We need to guess a hidden number between 1 and n.
 - The guess API tells us if our guess is too high (-1), too low (1), or correct (0).
 - Use binary search to minimize the number of guesses.

 Technique Used:
 Binary Search with API feedback

 Steps:
 1. Initialize low = 1, high = n.
 2. While low <= high:
    - Compute mid = low + (high - low) / 2.
    - Call guess(mid).
    - If guess(mid) == 0 → found the number → return mid.
    - If guess(mid) < 0 → our guess is too high → move high = mid - 1.
    - If guess(mid) > 0 → our guess is too low → move low = mid + 1.
 3. Return -1 if not found (though problem guarantees a solution).

 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

class GuessGame {
    private int picked; // the hidden number

    // Constructor to set the picked number
    public GuessGame(int picked) {
        this.picked = picked;
    }

    // The guess API
    public int guess(int num) {
        if (num == picked) return 0;       // correct
        else if (num > picked) return -1;  // too high
        else return 1;                     // too low
    }
}

/*
public class GuessNumberHigherOrLower extends GuessGame {
    public Solution(int picked) {
        super(picked); // pass picked number to GuessGame
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid; // found the number
            } else if (res < 0) {
                high = mid - 1; // guess too high
            } else {
                low = mid + 1; // guess too low
            }
        }
        return -1; // should never reach here
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower s = new GuessNumberHigherOrLower(6); // picked number = 6
        int result = s.guessNumber(10); // search range = 1 to 10
        System.out.println("Picked number is: " + result);
    }
}
*/