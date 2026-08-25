import java.util.Arrays;

class LC_1838 {
    public int maxFrequency(int[] nums, int k) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Left pointer of sliding window
        int left = 0;

        // Sum of elements inside current window
        long sum = 0;

        // Maximum frequency found
        int maxFreq = 0;

        // Expand the window using right pointer
        for (int right = 0; right < nums.length; right++) {

            // Add current element to window sum
            sum += nums[right];

            // Calculate cost of making every element
            // in the window equal to nums[right]
            while ((long) nums[right] * (right - left + 1) - sum > k) {

                // Remove leftmost element
                sum -= nums[left];

                // Shrink window
                left++;
            }

            // Current window is valid
            int windowSize = right - left + 1;

            // Update maximum frequency
            maxFreq = Math.max(maxFreq, windowSize);
        }

        return maxFreq;
    }
}