package Recursion.Practice2;
    
import java.util.*;

public class SubsetEqualTarget {
    public List<List<Integer>> subsets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result, 0, target);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current,
                           List<List<Integer>> result, int currentSum, int target) {
        if (index == nums.length) {
            if (currentSum == target) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Include nums[index]
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result, currentSum + nums[index], target);

        // Exclude nums[index]
        current.remove(current.size() - 1);
        backtrack(nums, index + 1, current, result, currentSum, target);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 3;
        System.out.println(Subsets(nums, target));
    }
}