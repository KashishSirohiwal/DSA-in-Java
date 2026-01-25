package Arrays.LeetCode;
import java.util.Scanner;

/*
 LeetCode Problem: Running Sum of 1D Array
 Approach:
 - Use prefix sum
 - Each element stores sum of all previous elements

 Time Complexity: O(n)
 Space Complexity: O(1) (in-place)
*/

public class RunningSumArray {
    public static int[] runningSum(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter element values : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = runningSum(nums);
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        } 
        sc.close();
    }
}