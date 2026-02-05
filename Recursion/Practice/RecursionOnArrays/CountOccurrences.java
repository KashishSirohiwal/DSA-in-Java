package Recursion.Practice.RecursionOnArrays;

public class CountOccurrences {
    public static int countOccurrrences(int[] arr, int target, int idx) {
        if (idx == arr.length) return 0;
        
        int count = (arr[idx] == target) ? 1 : 0;
        return count + countOccurrrences(arr, target, idx+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,3,4,4,4,4,4,4};
        int target = 4;
        int result = countOccurrrences(arr, target, 0);
        System.out.println("Count of occurrence of " + target + " : " + result);
    }
}
