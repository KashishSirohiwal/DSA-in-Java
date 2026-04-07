package Basic_MathLevel;
import java.util.HashMap;
import java.util.Map;

/*
Problem: Fraction to Recurring Decimal (LeetCode 166)

Idea:
- Convert a fraction (numerator/denominator) into a string representation.
- If the decimal part repeats, enclose the repeating sequence in parentheses.
- Use remainder tracking to detect cycles.

Technique Used:
Long Division Simulation + HashMap

Steps:
1. Handle sign: result is negative if numerator and denominator have opposite signs.
2. Compute integer part using division.
3. Use remainder to generate fractional digits:
 - Multiply remainder by 10, divide by denominator → next digit.
 - Store each remainder in a map with its position in the result string.
 - If a remainder repeats, insert "(" at its first occurrence and append ")" at the end.
4. Return the constructed string.

Time Complexity: O(n) where n is the length of the repeating cycle (bounded by denominator).
Space Complexity: O(n) for storing remainders in the map.
*/

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) return result.toString();

        result.append(".");

        // Fractional part with remainder tracking
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // repeating cycle detected
                int pos = map.get(remainder);
                result.insert(pos, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}