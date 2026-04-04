package Quick_Sort.LeetCode;
import java.util.*;

/*
Problem: K Closest Points to Origin (LeetCode 973)

Definition:
- Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
  and an integer k, return the k closest points to the origin (0,0).
- The distance is calculated as: distance = x^2 + y^2.

Example:
- Input: points = [[3,3],[5,-1],[-2,4]], k = 2
- Output: [[3,3],[-2,4]]

Approach:
1. Use Quickselect (partition-based selection).
2. Partition the array around a pivot distance.
3. If pivot index == k, we have the k closest points.
4. Otherwise, recurse into the half that contains the kth boundary.
5. Randomized pivot avoids worst-case O(n^2).

Technique Used: Quickselect (Divide and Conquer)

Observations:
- Quickselect is faster than sorting the entire array (O(n log n)).
- Average time complexity is O(n), worst-case O(n^2).
- Heap-based solutions are also possible (O(n log k)), but Quickselect is more efficient.

Time Complexity:
- Average: O(n)
- Worst-case: O(n^2) (avoided with randomized pivot)

Space Complexity: O(1) (in-place partitioning)
*/

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSelect(int[][] points, int low, int high, int k) {
        if (low < high) {
            int pi = partition(points, low, high);

            if (pi == k) {
                return;
            } else if (pi < k) {
                quickSelect(points, pi + 1, high, k);
            } else {
                quickSelect(points, low, pi - 1, k);
            }
        }
    }

    private int partition(int[][] points, int low, int high) {
        // Random pivot
        int pivotIndex = low + (int)(Math.random() * (high - low + 1));
        swap(points, pivotIndex, high);

        int[] pivot = points[high];
        int pivotDist = distance(pivot);

        int i = low;
        for (int j = low; j < high; j++) {
            if (distance(points[j]) <= pivotDist) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, high);
        return i;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] result = solution.kClosest(points, k);
        System.out.println(Arrays.deepToString(result)); // Output: [[3,3], [-2,4]]
    }
}
