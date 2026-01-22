package Arrays.Practice;

import java.util.Scanner;

public class ReverseNumber {
    public static int reverseno(int num) { 
        int reverse = 0;
        boolean isNegative = num < 0; // Checks if number is negative
        num = Math.abs(num); // Turning into positive equivalent
        while (num > 0) {
            int digit = num % 10; // Extract the last digit
            reverse = reverse * 10 + digit;
            num /= 10; // Remove last digit
        }
        return isNegative ? -reverse : reverse;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        int result = reverseno(num); // Math.abs turns no into positive
        System.out.println("The reverse of " + num + " is : " + result);
        sc.close();
    }
}
