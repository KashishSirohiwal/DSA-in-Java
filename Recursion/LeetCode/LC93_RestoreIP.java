package Recursion.LeetCode;

/*
Problem: Restore IP Addresses

Idea:
 - Use backtracking to generate all possible valid IP addresses from the given string.
 - For each segment, try to take 1 to 3 digits and check if it's a valid segment (0-255 and no leading zeros).
 - If valid, add it to the current list and recursively try to form the next segment.
 - If we reach the end of the string and have exactly 4 segments, add the current combination to the answer list.

Technique Used: Backtracking

Time Complexity: O(1) since the number of valid IP addresses is limited and does not depend on the input size.
Space Complexity: O(1) for the recursion stack, as the maximum depth is 4
*/

public class LC93_RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        // Current list to hold the segments of the IP address being formed
        List<String> current = new ArrayList<>();
        
        solve(s, 0, current, ans);
        return ans;
    }

    private void solve(String s, int index, List<String> current, List<String> ans) {
        // Base case: If we have reached the end of the string and have exactly 4 segments, add the current combination to the answer list
        if (index == s.length() && current.size() == 4) {
            ans.add(String.join(".", current));
            return;
        }

        int remainingSegments = 4 - current.size();
        int remainingDigits = s.length() - index;

        // Pruning: If the remaining digits are less than the remaining segments or more than 3 times the remaining segments, return early
        if (remainingDigits < remainingSegments || remainingDigits > remainingSegments * 3) return;
        
        // Try to take 1 to 3 digits for the current segment and check if it's valid
        for (int end = index; end < Math.min(index + 3, s.length()); end++) {
            // Extract the current segment from the string
            String segment = s.substring(index, end + 1);
            if (isValid(segment)) {
                current.add(segment);
                solve(s, end + 1, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        // Case 1: Segment length is greater than 3 or equal to 0
        if (segment.length() > 3 || segment.length() == 0) {
            return false;
        }
        // Case 2: Segment has leading zeros (e.g., "01", "00") but is not "0"
        else if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        // Case 3: Segment value is greater than 255
        int intSegment = Integer.parseInt(segment);
        if (intSegment > 255) {
            return false;
        }

        return true;
    }
}
