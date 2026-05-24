import java.util.*;

public class PalindromicPermutations {

    /* 
      PROBLEM: Given a string, generate all permutations of it that are palindromes.
     
      APPROACH:
      A palindrome mirrors around its center.
      So we only need to find all permutations of the LEFT HALF.
      The right half is always just the reverse of the left half.
     
      This reduces work from O(n!) to O((n/2)!)
    */

    public static List<String> palindromicPermutations(String s) {
        List<String> result = new ArrayList<>();

        // STEP 1: Count frequency of each character

        /* freqMap stores how many times each character appears in the string
           getOrDefault(c, 0) returns current count or 0 if not seen yet */

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // STEP 2: Check feasibility and find middle character

        /* A character with odd frequency cannot be mirrored evenly.
        At most ONE character can have odd frequency — it becomes the middle.
        If more than one character has odd frequency → impossible.
        
        middleChar = 0 means no middle character (even length palindrome) */

        int oddCount = 0;
        char middleChar = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
                middleChar = entry.getKey();
            }
        }

        // More than one odd-frequency character → no palindrome possible
        if (oddCount > 1) {
            System.out.println("No palindromic permutation possible for: " + s);
            return result;
        }

        // STEP 3: Build left half
    
        StringBuilder leftHalf = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int halfCount = entry.getValue() / 2;
            for (int i = 0; i < halfCount; i++) {
                leftHalf.append(entry.getKey());
            }
        }

        // STEP 4: Generate all unique permutations of left half
    
        char[] chars = leftHalf.toString().toCharArray();
        Arrays.sort(chars);

        /* HashSet tracks which permutations of the left half we have already seen.
        WHY NEEDED: if left half has duplicate characters like "aab",
        the swap-based permutation generator will produce "aab" multiple times
        because swapping the two 'a's produces the same arrangement.
        HashSet catches these duplicates at the base case and skips them. */
    
        Set<String> seen = new HashSet<>();

        generatePermutations(chars, 0, seen, result, middleChar);

        return result;
    }

    /*
      RECURSIVE FUNCTION: Generate all unique permutations of chars[]
      from position 'start' onward.
     
      PARAMETERS:
      chars   → the left half characters, modified in place via swapping
      start   → current position being filled (0 to chars.length-1)
      seen    → HashSet of left half permutations already processed
      result  → final list of complete palindromes
      middle  → middle character, or 0 if none exists
     
      BASE CASE: start == chars.length
      All positions filled. chars[] now holds one complete permutation
      of the left half. Build the full palindrome and record it.
     
      RECURSIVE CASE:
      Try every character from position 'start' to end as the next placement.
      Swap it into position 'start', recurse for start+1, swap back to undo.
    */
    private static void generatePermutations(char[] chars, int start, Set<String> seen, List<String> result, char middle) {
        if (start == chars.length) {
            String left = new String(chars);

            /* Check if this left half permutation was already processed
               This handles duplicate left half characters */
            if (seen.contains(left)) return;
            seen.add(left);

            String right = new StringBuilder(left).reverse().toString();

            /* Build complete palindrome
               middle != 0 checks if a middle character exists
               char default value is 0 (null character) meaning no middle */
            String palindrome = (middle != 0) ? left + middle + right : left + right;

            result.add(palindrome);
            return;
        }

        // Try each character from 'start' to end at position 'start'
        for (int i = start; i < chars.length; i++) {

            // Place chars[i] at position 'start' by swapping
            swap(chars, start, i);

            // Recurse to fill position start+1 onward
            generatePermutations(chars, start + 1, seen, result, middle);

            // UNDO the swap — restore array to state before this choice
            // so next iteration of the loop starts with clean array
            swap(chars, start, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {

        String s1 = "aab";
        System.out.println("Input: " + s1);
        System.out.println("Palindromic permutations: " + palindromicPermutations(s1));
        System.out.println();


        String s2 = "aabb";
        System.out.println("Input: " + s2);
        System.out.println("Palindromic permutations: " + palindromicPermutations(s2));
        System.out.println();

        String s3 = "abc";
        System.out.println("Input: " + s3);
        System.out.println("Palindromic permutations: " + palindromicPermutations(s3));
        System.out.println();

        String s4 = "aaaa";
        System.out.println("Input: " + s4);
        System.out.println("Palindromic permutations: " + palindromicPermutations(s4));
        System.out.println();

        String s5 = "a";
        System.out.println("Input: " + s5);
        System.out.println("Palindromic permutations: " + palindromicPermutations(s5));
        System.out.println();

        // Expected: 12 unique palindromes
        String s6 = "aaaabbcc";
        System.out.println("Input: " + s6);
        List<String> result6 = palindromicPermutations(s6);
        System.out.println("Count: " + result6.size());
        System.out.println("Palindromic permutations: " + result6);
    }
}