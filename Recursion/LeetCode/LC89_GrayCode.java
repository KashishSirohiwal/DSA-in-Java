package Recursion.LeetCode;

/*
Problem: Generate Gray Code Sequence
Given a non-negative integer n representing the total number of bits in the code, generate the sequence of Gray codes.
A Gray code sequence must begin with 0 and each subsequent number in the sequence must differ from the previous number by exactly one bit.
Example:
Input: n = 2
Output: [0, 1, 3, 2] (Explanation: The binary representations of the Gray code sequence are:
00 - 0
01 - 1
11 - 3
10 - 2)

Technical Explanation:
The Gray code for a given integer i can be generated using the formula:
G(i) = i ^ (i >> 1)
- ^ is the bitwise XOR operator and >> is the right shift operator. 
- Right shifting i by 1 effectively divides it by 2, and the XOR operation ensures that only one bit changes between consecutive numbers in the sequence.
- This formula ensures that each subsequent number in the sequence differs from the previous number by exactly one bit.
Example:
For n = 2, the total numbers in the Gray code sequence is 2^n = 4. 
The sequence is generated as follows:
i = 0: G(0) = 0 ^ (0 >> 1) = 0 ^ 0 = 0
i = 1: G(1) = 1 ^ (1 >> 1) = 1 ^ 0 = 1
i = 2: G(2) = 2 ^ (2 >> 1) = 2 ^ 1 = 3
i = 3: G(3) = 3 ^ (3 >> 1) = 3 ^ 1 = 2

Idea:
- Use a loop to iterate from 0 to 2^n - 1.
- For each integer i in this range, compute the corresponding Gray code using the formula G(i) = i ^ (i >> 1).
- Store the generated Gray codes in a list and return it as the final output.

Technique: Recursion + Bit Manipulation

Time Complexity: O(2^n) - We generate 2^n Gray codes, and each code is generated in constant time.
Space Complexity: O(2^n) - We store 2^n Gray codes in the result list.
*/

public class LC89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        generateGrayCode(n, 0, result);
        return result;
    }

    private void generateGrayCode(int n, int current, List<Integer> result) {
        // Base case: If the current number exceeds the maximum value for n bits, return
        if (current == (1 << n)) {
            return;
        }
        // Generate the Gray code for the current number and add it to the result list
        result.add(current ^ (current >> 1));

        // Recursively generate Gray codes for the next number
        generateGrayCode(n, current + 1, result);
    }
}