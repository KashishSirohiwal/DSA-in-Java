package Arrays.Practice;

import java.util.Scanner;

public class ReverseNumber {
    public static int reverseno(int num) { 
        int digit; int reverse = 0;
        while (num > 0) {
            digit = num % 10; // Extract the last digit
            reverse = reverse * 10 + digit;
            num /= 10; // Remove last digit
        }
        return reverse;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        int result = reverseno(Math.abs(num)); // Math.abs turns no into positive
        System.out.println("The reverse of " + num + " is : " + result);
        sc.close();
    }
}
