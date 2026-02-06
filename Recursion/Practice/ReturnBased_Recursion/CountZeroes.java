package Recursion.Practice.ReturnBased_Recursion;

import java.util.Scanner;

public class CountZeroes {
    public static int countZeroes(int num) {
        int count = 0;
        if (num / 10 == 0) {
            if (num % 10 == 0) return count + 1;
            return count;
        }
        if (num % 10 == 0) {
            return count + 1 + countZeroes(num / 10);
        }
        return count + countZeroes(num / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        int result = countZeroes(num);
        System.out.println("Count of zeroes: " + result);
        sc.close();
    }
}