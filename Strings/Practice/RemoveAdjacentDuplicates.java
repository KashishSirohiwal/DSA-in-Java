package Strings.Practice;

public class RemoveAdjacentDuplicates {
        public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1); // remove duplicate
            } else {
                sb.append(c); // push
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("aabbcc")); // ""
        System.out.println(sol.removeDuplicates("aabba"));  // "a"
        System.out.println(sol.removeDuplicates("abbaca")); // "ca"
    }
}