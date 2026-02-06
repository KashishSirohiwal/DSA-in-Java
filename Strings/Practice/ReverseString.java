package Strings.Practice;

import java.util.Scanner;

public class ReverseString {
    public static String reverseString(String str) {
        char[] charArr = str.toCharArray();
        int s = 0, e = charArr.length - 1;
        while (s<e) {
             int temp = charArr[s];
            charArr[s] = charArr[e];
            charArr[e] = (char) temp;
            s++;
            e--;
        }
        return new String(charArr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = reverseString(str);
        System.out.println("Reversed string: " + result);
        sc.close();
    }
}
