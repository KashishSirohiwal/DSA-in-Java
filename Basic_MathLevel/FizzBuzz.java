package Basic_MathLevel;
import java.util.ArrayList;
import java.util.List;

/*
Problem: Fizz Buzz (LeetCode 412)

Idea:
- Print numbers from 1 to n.
- For multiples of 3, output "Fizz".
- For multiples of 5, output "Buzz".
- For multiples of both 3 and 5, output "FizzBuzz".
- Otherwise, output the number itself.

Technique Used:
Simple Iteration with Modulo Checks

- Iterate from 1 to n.
- Use modulo (%) operator to check divisibility by 3 and 5.
- Append the correct string to the result list.

Time Complexity: O(n)
Space Complexity: O(n) (for storing the result list)
*/

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}