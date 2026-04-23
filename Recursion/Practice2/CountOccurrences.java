package Recursion.Practice2;

public class countOccurrences {
    public static int countOcc(int[] arr, int target, int i) {
        if (i == arr.length) return 0;
        int currentMatch = (arr[i] == target) ? 1 : 0;
        return currentMatch + countOcc(arr, target, i+1);

    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 5, 3, 5};
        int target = 5;
        int res = countOcc(arr, target, 0);
        System.out.println("Occurrence of " + target + " : " + res);
    }
}
