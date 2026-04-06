package Basic_MathLevel;
import java.util.Arrays;

/*
Problem: Count Primes (LeetCode 204)

Idea:
- Count the number of prime numbers less than a given integer n.
- Use the Sieve of Eratosthenes algorithm:
1. Assume all numbers are prime initially.
2. Starting from 2, eliminate multiples of each prime.
3. Continue until sqrt(n).
4. Count remaining numbers marked as prime.

Technique Used:
Sieve of Eratosthenes

- Efficiently marks non-primes by crossing out multiples.
- Avoids repeated division checks for each number.

Time Complexity: O(n log log n)
Space Complexity: O(n)
*/    

public class CountPrime {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        // Step 1: Initialize boolean array
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Step 2: Sieve process
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}