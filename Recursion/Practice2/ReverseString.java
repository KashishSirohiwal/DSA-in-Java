package Recursion.Practice2;

public class ReverseString {
    public static String revStr(String str) {
        if (str.length() <= 1) return str;

        return revStr(str.substring(1)) + charAt(0);
    }
    public static void main(String[] args) {
        String str = "Kashish";
        String res = revStr(arr);
        System.out.println("Reverse of " + str + " : " + res);
    }
}
