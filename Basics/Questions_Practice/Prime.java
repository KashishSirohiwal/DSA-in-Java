package Basics.Questions_Practice;

import java.util.Scanner;

public class Prime {
    public static String primecheck(int num) {
        if (num <= 1) return "Not prime";
        for (int i=2; i<num; i++) {
            if (num % i == 0) {
                return "Not prime"; // exit immediately
            }
        }
        return "Prime";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        System.out.println("The number " + num + " is " + primecheck(num));
        sc.close();
    }
}
