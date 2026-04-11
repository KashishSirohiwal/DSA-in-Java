package Binary_Search.LeetCode;
    
/*
 Problem: Sqrt(x) (LeetCode 69)

 Idea:
 - We need to compute the integer square root of x.
 - That means: return floor(sqrt(x)).
 - Use binary search to find the largest integer mid such that mid*mid <= x.

 Technique Used:
 Binary Search on Answer Space

 Steps:
 1. Initialize low = 1, high = x, ans = 0.
 2. While low <= high:
    - mid = low + (high - low)/2.
    - If mid*mid <= x:
        - Save ans = mid (candidate answer).
        - Move right (low = mid + 1) to check larger values.
    - Else:
        - Move left (high = mid - 1).
 3. Return ans.

 Note:
 - Cast mid to long before multiplication to avoid overflow.

 Time Complexity: O(log x)
 Space Complexity: O(1)
*/

public class sqrtx {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) mid * mid <= x) {
                ans = mid; // candidate answer
                low = mid + 1; // try larger
            } else {
                high = mid - 1; // try smaller
            }
        }
        return ans;
    }
}