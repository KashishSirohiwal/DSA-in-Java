package Recursion.Practice2;    
import java.util.*;

public class CountSubset {
    public static int numbersubset(int[] nums) {
        // total subsets = 2^n
        return (int) Math.pow(2, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(numbersubset(nums));
    }
}


/* Recursive approach

import java.util.*;

class Main {
    public static int numbersubset(int[] nums) {
        return countSubsets(nums, 0);
    }

    private static int countSubsets(int[] nums, int index) {
        if (index == nums.length) return 1;

        int include = countSubsets(nums, index + 1);

        int exclude = countSubsets(nums, index + 1);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(numbersubset(nums));
    }
}
*/