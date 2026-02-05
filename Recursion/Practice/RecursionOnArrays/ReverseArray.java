package Recursion.Practice.RecursionOnArrays;

public class ReverseArray {
    public static int[] reverseHelper(int[] arr, int start, int end) {
        if (start >= end) return arr;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
        return reverseHelper(arr, start, end);
    }
    
    public static int[] reverseArray(int[] arr) {
        reverseHelper(arr, 0, arr.length - 1);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] reversedArr = reverseArray(arr);
        System.out.print("Reversed array: ");
        for (int num : reversedArr) {
            System.out.print(num + " ");
        }
    }
}
