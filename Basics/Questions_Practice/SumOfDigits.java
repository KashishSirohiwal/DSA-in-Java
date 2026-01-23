package Basics.Questions_Practice;
import java.util.*;

public class SumOfDigits {
    public static int sumDigits(int num) { 
        int sum = 0; int rem;
        while (num > 0) {
            rem = num % 10; // To get remainder
            sum += rem; // Sum of each digit
            num = num/10; // To decrease digit by 1 from end
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        int result = sumDigits(Math.abs(num)); // Math.abs turns no into positive
        System.out.println("The sum of " + num + " is : " + result);
        sc.close();
    }
}
