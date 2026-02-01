package Arrays.LeetCode;
import java.util.Scanner;

public class TwoSum_II {

    /*
     Problem: Two Sum II – Input Array Is Sorted

     Description:
     - Given a sorted array of integers in non-decreasing order,
       find two numbers such that they add up to a specific target.
     - Return their indices in 1-based indexing.

     Approach:
     Two Pointer Technique

     - Initialize one pointer at the start (left) and one at the end (right).
     - Compute the sum of elements at both pointers.
     - If the sum equals the target, return their 1-based indices.
     - If the sum is less than the target, move the left pointer forward.
     - If the sum is greater than the target, move the right pointer backward.
     - Continue until the pair is found.

     Time Complexity: O(n)
     Space Complexity: O(1)
    */

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // fallback (though problem guarantees a solution)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        int[] result = twoSum(numbers, target);

        System.out.println("Indices (1-based): " + result[0] + " " + result[1]);

        sc.close();
    }
}
