package Binary_Search.LeetCode;
    
/*
 Problem: Find Smallest Letter Greater Than Target (LeetCode 744)

 Idea:
 - Given a sorted array of characters, return the smallest character strictly greater than target.
 - If no such character exists, wrap around and return the first character.
 - This is an application of the "upper bound" binary search.

 Technique Used:
 Binary Search (upper bound)

 Steps:
 1. Initialize low = 0, high = letters.length - 1.
 2. While low <= high:
    - Compute mid = low + (high - low) / 2.
    - If letters[mid] > target:
        - Save ans = letters[mid].
        - Move high = mid - 1 (search left for smaller valid answer).
      Else:
        - Move low = mid + 1 (search right).
 3. If no answer found in loop, wrap around → return letters[0].
 4. Otherwise return ans.

 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        char ans = letters[0]; // default wrap-around

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                ans = letters[mid];   // possible answer
                high = mid - 1;       // search left for smaller valid letter
            } else {
                low = mid + 1;        // need strictly greater
            }
        }
        return ans;
    }
}