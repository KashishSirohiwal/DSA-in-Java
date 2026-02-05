package Recursion.Practice.ReturnBased_Recursion;
import java.util.Scanner;

public class ProductOfDigits {
    public static int productOfDigits(int num) {
        int product = 1;
        if (num == 0) return product;
        product *= num % 10;
        return product * productOfDigits(num / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        int result = productOfDigits(num);
        System.out.println("Product of digits: " + result);
        sc.close();
    }
}