package BinarySearch.LeetCode;

/*
Problem: 1760. Minimum Limit of Balls in a Bag

Statement:
 - Given n bags with balls and maxOperations.
 - Each operation splits one bag into two smaller bags.
 - Minimize the maximum number of balls in any bag.

Idea:
 - Search space = [1, max(balls)].
 - For each mid, compute operations needed: (x-1)/mid for each bag.
 - If total operations ≤ maxOperations → feasible.
 - Binary search until smallest feasible mid.

Technique Used:
Binary Search on Answer + Greedy feasibility check

Time Complexity: O(n log(max(balls)))
Space Complexity: O(1)
*/

class MaxLimitOfBallsInBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int x : nums) right = Math.max(right, x);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDivide(int[] nums, int maxOperations, int mid) {
        long ops = 0;
        for (int x : nums) {
            ops += (x - 1) / mid;
            if (ops > maxOperations) return false;
        }
        return true;
    }
}