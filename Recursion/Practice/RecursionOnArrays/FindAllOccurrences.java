package Recursion.Practice.RecursionOnArrays;

public class FindAllOccurrences {
    public static String findAllOccurrences(int[] arr, int target, int idx) {
        if (idx == arr.length) return "";
        String res = findAllOccurrences(arr, target, idx+1); // recursive call to find occurrences in the rest of the array
        if (arr[idx] == target) {
            if (res.isEmpty()) { // if there are no occurrences found in the rest of the array, return current index as string
                return idx + "";
            } else {
                return idx + " " + res; // concatenate current index with results from recursive calls
            }
        } else { // current index does not match target, return results from recursive calls
            return res;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,2,2};
        int target = 2;
        String result = findAllOccurrences(arr, target, 0);
        System.out.println("Index of occurrences of target in array is: " + result);
    }
}
/*
how this works:
- The function `findAllOccurrences` takes an array, a target value, and an index
- It recursively calls itself to find occurrences in the rest of the array
- When it reaches the end of the array, it returns an empty string
- As the recursion unwinds, it checks if the current index matches the target
- If it matches, it concatenates the current index with the results from the recursive calls
- If it doesn't match, it simply returns the results from the recursive calls
example:
arr = [1,2,3,2,4,2,2], target = 2
- findAllOccurrences(arr, 2, 0) → calls findAllOccurrences(arr, 2, 1)
- findAllOccurrences(arr, 2, 1) → calls findAllOccurrences(arr, 2, 2)
- findAllOccurrences(arr, 2, 2) → calls findAllOccurrences(arr, 2, 3)
- findAllOccurrences(arr, 2, 3) → calls findAllOccurrences(arr, 2, 4)
- findAllOccurrences(arr, 2, 4) → calls findAllOccurrences(arr, 2, 5)
- findAllOccurrences(arr, 2, 5) → calls findAllOccurrences(arr, 2, 6)
- findAllOccurrences(arr, 2, 6) → calls findAllOccurrences(arr, 2, 7)
- findAllOccurrences(arr, 2, 7) → returns "" (base case)
- findAllOccurrences(arr, 2, 6) → arr[6] == 2 → returns "6"
- findAllOccurrences(arr, 2, 5) → arr[5] == 2 → returns "5 6"
- findAllOccurrences(arr, 2, 4) → arr[4] != 2 → returns "5 6"
- findAllOccurrences(arr, 2, 3) → arr[3] == 2 → returns "3 5 6"
- findAllOccurrences(arr, 2, 2) → arr[2] != 2 → returns "3 5 6"
- findAllOccurrences(arr, 2, 1) → arr[1] == 2 → returns "1 3 5 6"
- findAllOccurrences(arr, 2, 0) → arr[0] != 2 → returns "1 3 5 6"
- Final output: "Index of occurrences of target in array is: 1 3 5 6"   
*/