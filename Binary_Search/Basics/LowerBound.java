package Binary_Search.Basics;

/*
The lower bound of a target is:
the first index where the value is greater than or equal to the target.

Lower bound = first index where arr[i] >= target 
*/

public class LowerBound {
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 10};
        int target = 4;
        int res = lowerBound(arr, target);
        System.out.println("The lower bound is " + res);
    }
}
