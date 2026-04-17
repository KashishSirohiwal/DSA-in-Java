package Basic_MathLevel;
    
/*
Problem: 2485. Find Pivot Integer

Statement:
 - Given a positive integer n.
 - Find an integer x such that:
     sum(1...x) = sum(x...n)
 - If such x exists, return it; otherwise return -1.

Technique Used:
Prefix sum formula + direct check

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class FindPivotInetger {
    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        for (int x = 1; x <= n; x++) {
            int left = x * (x + 1) / 2;
            int right = total - left + x;
            if (left == right) return x;
        }
        return -1;
    }
}