package Hashing.LeetCode;

import java.util.*;

/*
Problem: Group Anagrams (LeetCode 49)

Idea:
- Anagrams are words that contain the same letters with the same frequency, just arranged differently.
- To group them, we need a "signature" that uniquely represents the letters of each word.
- Approach: Sort the characters of each word.
    * Example: "eat" -> "aet", "tea" -> "aet", "ate" -> "aet".
    * All anagrams share the same sorted form.
- Use a HashMap:
    * Key = sorted string (signature).
    * Value = list of words that share that signature.
- Finally, return all values of the HashMap as grouped anagrams.

Technique Used:
- HashMap for grouping.
- Sorting characters of each word to create a canonical signature.

Time Complexity: O(n * k log k)
    * n = number of words
    * k = maximum length of a word
    * Sorting each word takes O(k log k).
Space Complexity: O(n * k)
    * HashMap stores all words grouped by signature.
*/


class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            // Convert word to char array
            char[] chars = word.toCharArray();
            
            // Sort the characters
            Arrays.sort(chars);
            
            // Convert back to string (signature)
            String sortedWord = new String(chars);

            // Check if signature exists, if not create new list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            // Add the original word to the list for this signature
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = sol.groupAnagrams(strs);
        System.out.println(result);
    }
}
