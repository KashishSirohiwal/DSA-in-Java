package Recursion.Practice.ReturnBased_Recursion;
import java.util.Scanner;

public class SumOneToN {
    public static int sumOneToN(int num) {
        if (num == 0) {
            return 0;
        }
        return sumOneToN(num - 1) + num;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter a positive number : ");
        int num = sc.nextInt();

        System.out.print("The sum from 1 to " + num + " is: " + sumOneToN(num));
        sc.close();
    }
}
