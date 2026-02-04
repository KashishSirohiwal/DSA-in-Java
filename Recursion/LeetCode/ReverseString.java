package Recursion.LeetCode;

/*
 LeetCode Problem: Reverse String
 Approach:
 - Use recursion with two pointers (start and end)
 - Swap characters at start and end
 - Move pointers inward on each recursive call
 - Stop when start >= end (base case)

 Time Complexity: O(n)
 Space Complexity: O(n)  // recursion stack
*/

public class ReverseString {
    private void reverseHelper(char[] s, int start, int end) {
        // Base Case
        if (start >= end) {
            return;
        }

        // Swap characters
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        // Recursive Case
        reverseHelper(s, start + 1, end - 1);
    }
    public void reverseString(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s); // Output: "olleh"
    }
}
