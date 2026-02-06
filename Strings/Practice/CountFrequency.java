package Strings.Practice;

import java.util.Scanner;

public class CountFrequency {
    // approach using charAt() method
    public static int countFrequency(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count ++;
            }
        }
        return count;
    }

    // another approach using char array
    public static int countFrequencyCharArray(String str, char c) {
        int count = 0;
        char[] charArr = str.toCharArray();
        for (char ch : charArr) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: "); 
        String str = sc.nextLine();
        System.out.print("Enter a character to count its frequency: ");
        char c = sc.next().charAt(0);

        System.out.println("Using charAt() method:");
        int result = countFrequency(str, c);
        System.out.println("Frequency of '" + c + "' in the string: " + result);
        
        System.out.println("Using char array method:");
        int result2 = countFrequencyCharArray(str, c);
        System.out.println("Frequency of '" + c + "' in the string: " + result2);
        sc.close();
    }
}
