package Arrays.Practice;
import java.util.Scanner;

public class SumArray {
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; 
        }
        return sum;
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

        int result = sumArray(arr);
        System.err.println("Sum of array is : " + result);
        sc.close();
    }
}
