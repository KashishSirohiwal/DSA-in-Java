/*
Problem : LeetCode 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

Method : Two Pointers using current + previus

Steps:
1. Create a list to store the indices of critical points.
2. Traverse the linked list using two pointers (prev and curr) to identify critical points.
3. For each node, check if it is a local maximum or minimum by comparing its value with its previous and next nodes.
4. If a critical point is found, add its index to the list.
5. After traversing the list, check if there are at least two critical points. If not, return [-1, -1].
6. Calculate the minimum distance between consecutive critical points by iterating through the list of indices.
7. Calculate the maximum distance between the first and last critical points.

Time Complexity : O(n) where n is the number of nodes in the linked list.
Space Complexity : O(k) where k is the number of critical points found in the linked list.
*/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList<>(); // Store the indices of critical points
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // curr is at position 1

        while (curr.next != null) {
            ListNode next = curr.next;

            // check local max or min
            if ((prev.val < curr.val && curr.val > next.val) ||
                (prev.val > curr.val && curr.val < next.val)) {
                criticalPoints.add(index);
            }

            prev = curr;
            curr = next;
            index++;
        }

        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;
        // Calculate the minimum distance between consecutive critical points
        for (int i = 1; i < criticalPoints.size(); i++) {
            minDist = Math.min(minDist, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }
        
        // Calculate the maximum distance between the first and last critical points
        int maxDist = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        return new int[]{minDist, maxDist};
    }
}