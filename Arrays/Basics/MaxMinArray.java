package Arrays.Basics;
import java.util.Scanner;

public class MaxMinArray {
    public static void findMaxMin(int[] arr) {
        // Assume first element as max & min
        int max = arr[0];
        int min = arr[0];  
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max element : " + max);
        System.out.println("Min element : " + min);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter element values : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMaxMin(arr);
        sc.close();
    }
}
