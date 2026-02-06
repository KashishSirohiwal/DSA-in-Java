package Recursion.Practice.RecursionOnArrays;

public class MinMax {
    public static int[] minMax(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return new int[]{arr[idx], arr[idx]};
        }
        int[] minmax = minMax(arr, idx + 1); // Recursive call for the rest of the array
        if (arr[idx] < minmax[0]) { // Update minimum
            minmax[0] = arr[idx];
        }
        if (arr[idx] > minmax[1]) { // Update maximum
            minmax[1] = arr[idx];
        }
        return minmax; // Return the updated min and max
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 2};
        int[] result = minMax(arr, 0);
        System.out.println("Minimum: " + result[0]);
        System.out.println("Maximum: " + result[1]);
    }
}
