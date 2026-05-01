package Recursion.Practice2;

import java.util.List;

public class SubsetInSortedOrder {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // Ensure the input array is sorted

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);

        result.sort((a, b) -> {
            int minSize = Math.min(a.size(), b.size());
            for (int i = 0; i < minSize; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        });
        return result;
    }

    private static void backtrack(int[] nums, int index, List<Integer> current,
                                  List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include nums[index]
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);

        // Exclude nums[index]
        current.remove(current.size() - 1);
        backtrack(nums, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(subsets(nums));
    }
}