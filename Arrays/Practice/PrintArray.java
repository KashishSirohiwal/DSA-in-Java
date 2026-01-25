package Arrays.Practice;
import java.util.*;
public class PrintArray {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at pos " + (i+1) + " : " + arr[i]);
        }
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

        printArray(arr);
        sc.close();
    }
}
