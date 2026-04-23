package Recursion.Practice2;

public class SumElement {
    public static int sumEle(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + sumEle(arr, i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7};
        int res = sumEle(arr, 0);
        System.out.println("Sum of elements : " + res);
    }
}