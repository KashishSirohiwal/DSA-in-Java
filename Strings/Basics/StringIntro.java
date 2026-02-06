package Strings.Basics;
/*
String is a immutable sequence of characters. It is a data type that is used to represent text. 
In Java, strings are objects that belong to the String class.
*/

public class StringIntro {
    public static void main(String[] args) {
        // String Intoduction
        String str1 = "Hello"; // String literal
        System.out.println("String 1: " + str1); // Hello
        
        // Differnce between String & Char 
        char ch = 'A'; // Char literal, represents a single character
        String str3 = "A"; // String literal, represents a string of length 1
        System.out.println("Character: " + ch); // A
        System.out.println("String: " + str3); // A
        
        // Differnece between String & char Array
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        charArray[0] = 'h'; // Modifying char array
        System.out.println("Char Array: " + new String(charArray)); // hello

        String s = "hello"; 
        System.out.println("String: " + s); // hello
        // s.charAt(0) = 'H'; // Error: Strings are immutable

        // What actually immutable means?
        String immutableStr = "Immutable";
        s = s + " String"; // Creates a new String object,  s now points to the new object
        System.out.println("Modified String: " + s); // hello String
        System.out.println("Original String: " + immutableStr); // Immutable

        // String Memory (String Constant Pool)
        // Constant Pool is a special memory region where Java stores string literals.
        String a = "Java"; // Stored in string pool
        String b = "Java"; // Points to the same object in string pool
        System.out.println(a == b); // true, both refer to the same object in string pool

        String c = new String("Java"); // c point to new object in heap memory
        System.out.println(a == c); // false, different objects in memory

        // String Comparison
        // == operator checks for reference equality (same object in memory)
        // .equals() method checks for value equality (same content)
        String strA = "Hello";
        String strB = "Hello";
        System.out.println(strA.equals(strB)); // true, content is same
        System.out.println(strA == strB); // true, both refer to same object in string pool

        String strC = new String("Hello");
        System.out.println(strA.equals(strC)); // true, content is same
        System.out.println(strA == strC); // false, different objects in memory

        // Length of String
        String strLength = "Hello World";
        System.out.println("Length of String: " + strLength.length()); // 11

        // Character at a specific index
        System.out.println("Character at index 0: " + strLength.charAt(0)); // H
        System.out.println("Character at index 6: " + strLength.charAt(6)); // W

        // Substring
        System.out.println("Substring from index 0 to 5: " + strLength.substring(0, 5)); // Hello
        System.out.println("Substring from index 6 to end: " + strLength.substring(6)); // World

        // Traversing a String
        System.out.println("Traversing the string:");
        for (int i = 0; i < strLength.length(); i++) {
            System.out.print(strLength.charAt(i) + " "); // H e l l o   W o r l d 
        }

        // String to Char Array, in order to make modification in string we need to convert it into char array because string is immutable
        char[] charArr = strLength.toCharArray(); // Converts the string to a char array
        System.out.println("\nString to Char Array:");
        for (char char1 : charArr) {
            System.out.print(char1 + " "); // H e l l o   W o r l d 
        }
    }
}
