package Arrays.Basics;

import java.util.Scanner;

/*
Linear Search is a searching technique where each element 
of the array is checked one by one until the target element
is found or the array ends.
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element if found, return index
            }
        }
        return -1; // Element not found
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter element values : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search : ");
        int target = sc.nextInt();
        int index = linearSearch(arr, target);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
        sc.close();
    }   
}
