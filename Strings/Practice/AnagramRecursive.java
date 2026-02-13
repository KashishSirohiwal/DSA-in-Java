package Strings.Practice;

public class AnagramRecursive {
    public static boolean isAnagram(String s, String t) {
        // Base case: If both strings are empty, they are anagrams
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        
        // If the lengths of the strings are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Recursive case: Check if the first character of s is in t
        char firstChar = s.charAt(0);
        int indexInT = t.indexOf(firstChar);
        
        // If the character is not found in t, they are not anagrams
        if (indexInT == -1) {
            return false;
        }
        
        // Remove the first character from s and the corresponding character from t
        String newS = s.substring(1);
        String newT = t.substring(0, indexInT) + t.substring(indexInT + 1);
        
        // Recur with the remaining characters
        return isAnagram(newS, newT);
    }

    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";
        boolean result = isAnagram(s, t);
        System.out.println("Are the two strings anagrams? " + result);
    }
}
