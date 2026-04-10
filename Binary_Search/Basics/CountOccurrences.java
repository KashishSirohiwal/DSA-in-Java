package Binary_Search.Basics;

public class CountOccurrences {
    public int countOccurrences(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) return 0; // target not found
        int last = findBound(nums, target, false);
        return last - first + 1;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;
        int bound = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    high = mid - 1; // keep searching left
                } else {
                    low = mid + 1;  // keep searching right
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bound;
    }

    public static void main(String[] args) {
        CountOccurrences co = new CountOccurrences();
        int[] nums = {1,2,2,2,3,4,5};
        int target = 2;
        System.out.println("Count of " + target + " = " + co.countOccurrences(nums, target));
    }
}