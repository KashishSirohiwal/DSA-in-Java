package Recursion.LeetCode;

/*
Problem: LeetCode 394. Decode String

Example:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Idea:
 - Use a recursive helper function to decode the string.
 - Maintain an index pointer to track our position in the string.
 - When we encounter a digit, parse the full number (k), then recursively decode the substring inside the brackets.
 - Append the decoded substring k times to the result.
 - If we encounter a letter, append it directly to the result.

Technique Used:
 - Recursion with an index pointer to manage state across recursive calls.

Time Complexity: O(maxK^countK * n) where maxK is the maximum value of k and countK is the number of 
                 k's in the string. In practice, this is often much less than O(n^2).
Space Complexity: O(n) for the recursion stack and the result string.
*/

public class DecodeString {
    public String Decode(String s) {
        int[] index = {0}; // use array to pass index by reference
        return decodeHelper(s, index); 
    }

    public String decodeHelper(String s, int[] index) {
        StringBuilder result = new StringBuilder();
        
        // Process until we reach the end of the string or a closing bracket
        while (index[0] < s.length() && s.charAt(index[0]) != ']') {
            
            // If it's a digit, we need to decode the substring
            if (Character.isDigit(s.charAt(index[0]))) {
                int k = 0;
                // Build the number k (could be multiple digits)
                while (index[0] < s.length() && Character.isDigit(s.charAt(index[0]))) {
                    k = k * 10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }

                index[0]++; // skip the '['
                
                String decodedString = decodeHelper(s, index);
                
                index[0]++; // skip the ']'
                
                // Append the decoded string k times to the result
                for (int i = 0; i < k; i++) {
                    result.append(decodedString);
                }
            } 
            // If it's a letter, just append it to the result
            else {
                result.append(s.charAt(index[0]));
                index[0]++;
            }
        }
        return result.toString();
    }  
}