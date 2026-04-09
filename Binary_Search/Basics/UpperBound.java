package Binary_Search.Basics;

/*
Upper Bound is:
the first index where the value is strictly greater than target

Upper Bound = first index where arr[i] > target
*/

public class UpperBound {
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 10};
        int target = 4;
        int res = lowerBound(arr, target);
        System.out.println("The lower bound is " + res);
    }
}