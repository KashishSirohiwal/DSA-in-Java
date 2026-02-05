package Recursion.Practice.RecursionOnArrays;

public class LinearSearchBoolean {
    public static boolean linearSearchBoolean(int[] arr, int target, int idx) {
        if (idx == arr.length) return false;
        if (arr[idx] ==  target) return true;
        return linearSearchBoolean(arr, target, idx+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 4;
        boolean result = linearSearchBoolean(arr, target, 0);
        System.out.println("Does target exist in array? " + result);
    }
}
