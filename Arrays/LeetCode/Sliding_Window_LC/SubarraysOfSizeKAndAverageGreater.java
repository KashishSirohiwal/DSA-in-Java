package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

 Approach (Fixed Size Sliding Window):
 - Compute sum of first window of size k
 - If sum >= k * threshold → valid subarray
 - Slide the window:
       add next element
       remove element leaving the window
 - Check condition for every window

 Why multiply instead of dividing?
 - Avoid floating point division
 - sum / k >= threshold
   ⇒ sum >= threshold * k

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SubarraysOfSizeKAndAverageGreater {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0, c = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= threshold * k) c++;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            if (sum >= threshold * k) c++;
        }
        return c;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;

        int result = numOfSubarrays(arr, k, threshold);
        System.out.println("The subarray having size " + k + " & average greater than " + threshold +  " : " + result);
    }
}
