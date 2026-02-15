package Arrays.Prefix_Sum;
import java.util.*;

/*
Prefix sum (also called cumulative sum) is a simple yet remarkably useful technique.
A prefix sum is essentially a sequence of running totals. For an array, the prefix 
sum at any position is the sum of all elements up to that position.
*/

class IntoPrefixSum {
    public static void main(String[] args) {
        /* For an array A of n elements [a1,a2,a3....an], prefix sum
           array P of length n+1 is defined as :
           - P[0] = a1
           - P[i] = a1 + a2 +a3 + ... + ai for 1 ≤ i ≤ n
        */

        /*
        Logic is : precuompute cumulative information, so future queries become constant time

        prefix[0] = arr[0];
        for i from 1 → n-1 {
            prefix[i] = prefix[i-1] + arr[i];
        }
        */

        int[] arr = {3, 1, 4, 1, 5};
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i]; // Prefix array
        }

        System.out.println("Prefix array : ");
        for(int x : prefix) {
            System.out.print(x + " ");
        }

        /*
        Finding sum for any range
        - For sum(1,3) = prefix[3] - prefix[0]
        
        sum(L, R) = prefix[R] - prefix[L - 1]
        if L = 0: sum = prefix[R]
        */

        System.out.println("\nSum from range");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter left range : ");
        int L = sc.nextInt();
        System.out.print("Enter right range : ");
        int R = sc.nextInt();

        int result;
        if (L == 0) result = prefix[R];
        else result = prefix[R] - prefix[L - 1];
        System.out.println("Sum(" + L + ", " + R + ") : " + result);
        sc.close();
    }
}