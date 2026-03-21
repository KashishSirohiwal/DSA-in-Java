package Arrays.Kadane_Algo;

/*
1. If array is circular such as : [5, -3, 5], then subarray can wrap to around : 5(end) + 5(start) = 10
Normal Kadane won't catch this

2. Maximum circular sum = Total Sum - Minimum Subarray Sum
If we remove minimum subarray, then remaining part becomes maximum circular subarray

3. Steps :
  - Find normal max(Kadane)
  - Find total sum
  - Find min subarray(Kadane vairant)
  - Compute : circularSum = totalSum - minSubarraySum
  - Result : max(normalSum, circularSum)
*/

public class CircularKadane {
    public static int maxCircularSum(int[] arr) {
        int totalSum = 0;
        int currentMax = arr[0], maxSum = arr[0];
        int currentMin = arr[0], minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];

            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
    public static void main(String[] args) {
        int[] arr = {5, -3, 5, 8};
        int result = maxCircularSum(arr);
        System.out.println("Max : " + result);
    }    
}
