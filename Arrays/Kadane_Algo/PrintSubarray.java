package Arrays.Kadane_Algo;

/*
To print the subarray through kadane approach we maintain:
1. start :  where current subarray begins
2. end : where best subarray ends
3. tempStart : potential starting index when we restart
*/

public class PrintSubarray {
    public static void maxSubarray(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum = currentSum + arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Max Sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubarray(arr);
    }
}
