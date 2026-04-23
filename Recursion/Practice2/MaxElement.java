package Recursion.Practice2;

public class MaxElement {
    public static int maxEle(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        int max = maxEle(arr, i+1);
        return Math.max(arr[i], max);
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 6};
        int res = maxEle(arr, 0);
        System.out.println(res);
    }
}
