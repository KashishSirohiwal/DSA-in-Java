package Arrays.LeetCode;
import java.util.Scanner;

/*
 Problem: Reverse String

 Description:
 - Given a character array, reverse the array in-place.
 - No extra array should be used.

 Approach:
 Two Pointer Technique

 - Initialize one pointer at the start and one at the end.
 - Swap the characters at both pointers.
 - Move both pointers toward the center.
 - Continue until the pointers meet.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ReverseString {
  public static void reverseString(char[] s) {
    int left = 0; // Pointer at start
    int right = s.length - 1; // Pointer at end

    while (left < right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
          
      left++;
      right--;
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = sc.nextLine();

    // Handle empty input
    if (input.isEmpty()) {
      System.out.println("You entered an empty string.");
      sc.close();
      return;
    }

    char[] arr = input.toCharArray();
    reverseString(arr);

    System.out.print("Reversed string: ");
    for (char c : arr) {
      System.out.print(c);
    }
    sc.close();
  }
}
