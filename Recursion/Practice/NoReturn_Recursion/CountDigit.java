package Recursion.Practice.NoReturn_Recursion;
import java.util.Scanner;

public class CountDigit {
    public static int countDigit(int num) {
        int count = 0;
        if (num / 10 == 0) {
            return count + 1;
        }
        return count + 1 + countDigit(num / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        int result = countDigit(num);
        System.out.println("Sum of digits: " + result);
        sc.close();
    }
}
