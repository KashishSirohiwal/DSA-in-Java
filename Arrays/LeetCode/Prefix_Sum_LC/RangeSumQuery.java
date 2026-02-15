package Arrays.LeetCode.Prefix_Sum_LC;

/*
 LeetCode Problem: Range Sum Query - Immutable

 Approach:
 - Precompute prefix sum array
 - prefix[i] stores sum of elements from index 0 → i
 - To get sum from left → right:
        sum = prefix[right] - prefix[left - 1]
 - If left == 0 → directly return prefix[right]

 Why Prefix Sum?
 - Each query runs in O(1)
 - Preprocessing takes O(n)

 Time Complexity:
 - Constructor → O(n)
 - sumRange() → O(1)

 Space Complexity: O(n)
*/

public class RangeSumQuery {

    private int[] prefix;

    public RangeSumQuery(int[] nums) {
        // handle null or empty input
        if (nums == null || nums.length == 0) {
            this.prefix = new int[0];
            return;
        }

        prefix = new int[nums.length];
        prefix[0] = nums[0];

        // Build prefix sum array
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // If range starts from index 0
        if (left == 0) {
            return prefix[right];
        }

        // General case
        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rsq = new RangeSumQuery(nums);

        System.out.println("sumRange(0, 2) = " + rsq.sumRange(0, 2));   // 1
        System.out.println("sumRange(2, 5) = " + rsq.sumRange(2, 5));   // -1
        System.out.println("sumRange(0, 5) = " + rsq.sumRange(0, 5));   // -3
    }
}
