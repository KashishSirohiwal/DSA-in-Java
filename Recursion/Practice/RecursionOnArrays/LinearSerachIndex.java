package Recursion.Practice.RecursionOnArrays;

public class LinearSerachIndex {
    public static int linearSearchIndex(int[] arr, int target, int idx) {
        if (idx == arr.length) return -1;
        if (arr[idx] ==  target) return idx;
        return linearSearchIndex(arr, target, idx+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 3;
        int result = linearSearchIndex(arr, target, 0);
        System.out.println("Index of target in array is: " + result);
    }
}
