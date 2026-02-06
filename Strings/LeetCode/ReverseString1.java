package Strings.LeetCode;

import java.util.Scanner;

public class ReverseString1 {
    public static String reverseString1(String str) {
        char[] charr = str.toCharArray();
        int s = 0; int e = str.length() - 1;

        while (s < e) {
            char temp = charr[s];
            charr[s] = charr[e];
            charr[e] = temp;
            s++;
            e--;
        }
        return new String(charr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String res = reverseString1(str);
        System.out.println("Reversed string: " + res);
        sc.close();
    }
}
