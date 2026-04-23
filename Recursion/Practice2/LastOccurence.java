package Recursion.Practice2;

public class LastOccurrence {
    public static int lastOccurrence(String s, char target, int i) {
        if (i == s.length()) return -1;

        int indexInRest = lastOccurrence(s, target, i + 1);
        if (indexInRest != -1) return indexInRest;

        if (s.charAt(i) == target) return i;
        return -1;
    }

    public static void main(String[] args) {
        String str = "Banana";
        int res = lastOccurrence(str, 'a', 0);
        System.out.println(res);
    }
}