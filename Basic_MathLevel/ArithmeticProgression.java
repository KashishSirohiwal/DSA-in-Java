package Basic_MathLevel;
    
/*
 Problem: Can Make Arithmetic Progression From Sequence

 Statement:
 - Given an array, check if it can be rearranged to form an arithmetic progression.

 Idea:
 - Sort the array.
 - Check if consecutive differences are equal.

 Technique Used:
 Sorting + Linear Scan

 Time Complexity: O(n log n)
 Space Complexity: O(1)
*/

import java.util.Arrays;

public class ArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) return false;
        }
        return true;
    }
}