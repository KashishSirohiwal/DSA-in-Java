package Strings.Practice;
// Print each character of string

public class CharOfString {
    public static String charOfString(String str, int idx) {
        if (idx == str.length()) {
            return "";
        }
        return str.charAt(idx) + " " + charOfString(str, idx + 1);
    }

    // Without recursion
    public static void charOfStringIterative(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Recursive approach:");
        String result = charOfString(str, 0);
        System.out.println(result);

        System.out.println("Iterative approach:");
        charOfStringIterative(str);
    }
}
