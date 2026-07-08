package Recursion.Practice2;

public class ScrambleStrings {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return solve(s1, s2);
    }

    private boolean solve(String s1, String s2) {
        // Base case
        if (s1.equals(s2)) return true;

        if (s1.length() == 1 && !s1.equals(s2)) return false;

        int n = s1.length();
        for (int i = 1; i < s1.length(); i++) {
            // Partition s1 and s2 into two parts
            String leftS1  = s1.substring(0, i);
            String rightS1 = s1.substring(i);
            String leftS2 = s2.substring(0, i);
            String rightS2 = s2.substring(i);

            // Check if the left and right parts are scramble strings without swapping
            if (solve(leftS1, leftS2) && solve(rightS1, rightS2)) return true;

            // Partition s2 into two parts for swapping
            String swapLeftS2 = s2.substring(0, n - i);
            String swapRightS2 = s2.substring(n - i);

            // Check if the left and right parts are scramble strings with swapping
            if (solve(leftS1, swapRightS2) && solve(rightS1, swapLeftS2)) return true;
        }
        return false;
    }   
}