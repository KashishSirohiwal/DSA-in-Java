package Basic_MathLevel;

/*
Problem: Add Digits (LeetCode 258)

Idea:
- Given a non-negative integer num, repeatedly add its digits until the result has only one digit.
- Instead of simulating digit addition, use the mathematical property of the digital root:
- Digital root can be computed directly using modulo 9.
- Formula: result = 1 + (num - 1) % 9
- Special case: if num = 0, return 0.

Technique Used:
Digital Root (Mathematical Formula)

- Avoids iterative digit summation.
- Uses modulo arithmetic to compute the single-digit result in O(1).

Time Complexity: O(1)
Space Complexity: O(1)
*/

public class AddDigits {
        public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}
