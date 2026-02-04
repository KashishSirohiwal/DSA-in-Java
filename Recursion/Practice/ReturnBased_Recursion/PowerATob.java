package Recursion.Practice.ReturnBased_Recursion;
import java.util.Scanner;

public class PowerATob {
    public static int powerATob(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * powerATob(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base (a) : "); 
        int a = sc.nextInt();
        System.out.print("Enter exponent (b) : ");
        int b = sc.nextInt();
        int result = powerATob(a, b);
        System.out.println(a + " raised to the power of " + b + " is : " + result);
        sc.close();
    }

    /*
    In stack trace:
    powerATob(2, 3) calls
    - powerATob(2, 2)
    - powerATob(2, 1)
    - powerATob(2, 0)
    - returns 1
    - returns 2 * 1 = 2
    - returns 2 * 2 = 4
    - returns 2 * 4 = 8
    2^3 = 8
    */
}
