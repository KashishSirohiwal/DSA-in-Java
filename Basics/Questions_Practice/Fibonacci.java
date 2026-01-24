package Basics.Questions_Practice;
import java.util.Scanner;

public class Fibonacci {
    public static void fibonacci(int num) {
        int n1 = 0, n2 = 1;
        for (int i=0; i<num; i++) {
            System.out.print(n1 + " ");
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number till to find fib series : ");
        int num = sc.nextInt();
        fibonacci(num);
        sc.close();
    }
}
