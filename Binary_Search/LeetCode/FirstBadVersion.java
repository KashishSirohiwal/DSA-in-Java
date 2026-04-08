package Binary_Search.LeetCode;

/*
Problem: First Bad Version (LeetCode 278)

Idea:
 - Versions are either good or bad, and once a version is bad, all later versions are bad.
 - We need to find the first bad version (the boundary point).
 - Use binary search to minimize API calls.

Technique Used:
Binary Search on Monotonic Property (Boundary Search)

Steps:
1. Initialize low = 1, high = n.
2. While low < high:
 - Compute mid = low + (high - low) / 2.
 - If isBadVersion(mid) is true → mid could be the first bad version, so move high = mid.
 - Else → mid is good, so move low = mid + 1.
3. When loop ends, low == high → return low (the first bad version).

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid; // mid might be the answer
            } else {
                low = mid + 1; // mid is good, move right
            }
        }
        return low; // boundary point
    }
}

// Mock VersionControl class for local testing
class VersionControl {
    // Simulate the API: define the first bad version manually
    private int firstBad = 7;
    boolean isBadVersion(int version) {
        return version >= firstBad;
    }
}

public class FirstBadVersion {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 10; // total versions
        int firstBad = s.firstBadVersion(n);
        System.out.println("First bad version is: " + firstBad);
    }
}