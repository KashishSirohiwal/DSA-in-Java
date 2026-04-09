package Basic_MathLevel;

public class AddBinary {
    /*
     Problem: Add Binary (LeetCode 67)

     Idea:
     - Perform binary addition digit by digit from right to left.
     - Track carry just like normal addition.
     - Build result in reverse and then reverse at the end.

     Technique Used:
     String Traversal + Carry Handling

     Steps:
     1. Initialize pointers at the end of both strings.
     2. Loop while there are digits left or carry is non-zero.
     3. Add digits + carry, compute bit and new carry.
     4. Append bit to result.
     5. Reverse result at the end.

     Time Complexity: O(max(len(a), len(b)))
     Space Complexity: O(max(len(a), len(b)))
    */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);   // current bit
            carry = sum / 2;      // update carry
        }

        return sb.reverse().toString();
    }
}