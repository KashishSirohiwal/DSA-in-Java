package Basics.Questions_Practice;

import java.util.Scanner;

public class EvenOdd {
    public static String evenodd(int num) {
        if (num % 2 == 0) {
            return "is Even";
        }
        else {
            return "is Odd";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        System.out.println("The number " + num + " " + evenodd(num));
        sc.close();
    }
}
