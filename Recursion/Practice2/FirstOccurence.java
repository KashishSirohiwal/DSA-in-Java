package Recursion.Practice2;

public class FirstOccurence {
    public static int firstOccurrence(String s, char target, int i) {
        if (i == s.length()) return -1;
        if (s.charAt(i) == target) return i;
        return firstOccurrence(s, target, i + 1);
    }

    public static void main(String[] args) {
        String str = "Kashish";
        int res = firstOccurrence(str, 'a', 0);
        System.out.println(res);
    }
}