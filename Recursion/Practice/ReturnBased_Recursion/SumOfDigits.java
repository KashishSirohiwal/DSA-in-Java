package Recursion.Practice.ReturnBased_Recursion;
import java.util.Scanner;

public class SumOfDigits {
    public static int sumOfDigits(int num) {
        int sum = 0;
        if (num == 0) {
            return sum;
        }
        sum += num % 10;
        return sum + sumOfDigits(num / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        int result = sumOfDigits(num);
        System.out.println("Sum of digits: " + result);
        sc.close();
    }
}