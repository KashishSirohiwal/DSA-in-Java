package Arrays.LeetCode;
import java.util.Scanner;
/*
 Problem: Container With Most Water

 Idea:
 - Each element represents the height of a vertical line.
 - A container is formed by choosing any two lines.
 - Water capacity depends on:
     width  = distance between the two lines
     height = minimum of the two heights.
 - The goal is to maximize the container area.

 Technique Used:
 Two Pointer Technique (Opposite Direction)

 - Start with one pointer at the beginning and one at the end.
 - Calculate the area formed by the two pointers.
 - Move the pointer with the smaller height inward,
   because width always decreases and only height can improve area.
 - Continue until both pointers meet.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ContainerMaxWater {
    public static int containerMax(int[] height) {
        int maxArea = 0;

        int left = 0; // left pointer
        int right = height.length - 1; // right pointer

        while (left < right) {

            // Calculate current area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            // Update maximum area if needed
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++; // move right 
            } else {
                right--; // move left
            }
        }
        return maxArea;
    }
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] height = new int[n];

        System.out.println("Enter element values : ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = containerMax(height);
        System.out.println("The maximum water which container holds : " + result);
        sc.close();
    }
}
