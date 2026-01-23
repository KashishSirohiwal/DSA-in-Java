package Basics.Questions_Practice;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int num) {
        int fact = 1, i; 
        if (num == 0 || num == 1) return 1;
        for (i = 2; i<=num; i++) {
            fact *= i;
        }
        return fact;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        System.out.println("The factorial of number " + num + " is : " + factorial(num));
        sc.close();
    }
}
