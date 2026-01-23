package Basics.Questions_Practice;
import java.util.*;
public class DigitCount {
    public static int digitCount(int num) {
        int count = 0; 
        num = Math.abs(num);
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        System.out.println("The digit count of number " + num + " is : " + digitCount(num));
        sc.close();
    }
}
