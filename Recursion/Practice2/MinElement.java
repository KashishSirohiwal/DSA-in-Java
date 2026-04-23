package Recursion.Practice2;

public class MinElement {
    public static int minEle(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        int min = minEle(arr, i+1);
        return Math.min(arr[i], min);
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 6};
        int res = minEle(arr, 0);
        System.out.println(res);
    }
}
