package Recursion.Practice.RecursionOnArrays;

public class CheckSorted {
    public static boolean isSorted(int[] arr, int index) {

        // Base case: reached last element
        if (index == arr.length - 1) {
            return true;
        }

        // If current pair is invalid → not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Check remaining array
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Is the array sorted? ");
        System.out.print(isSorted(arr, 0));
    }
}
