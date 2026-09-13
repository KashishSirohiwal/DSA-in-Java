/*
Problem: 160. Intersection of Two Linked Lists

Method: Two Pointer Technique

Steps:
1. Initialize two pointers, cA and cB, to the heads of the two linked lists (headA and headB).
2. Traverse both linked lists simultaneously:
   - Move cA to the next node in list A, and cB to the next node in list B.
   - If either pointer reaches the end of its respective list, redirect it to the head of the other list.
3. Continue this process until the two pointers meet at the intersection node or both reach the end (null) if there is no intersection.

Time Complexity: O(m + n) - In the worst case, we traverse both linked lists once, where m and n are the lengths of the two lists.
Space Complexity: O(1) - We use a constant amount of space for the two pointers
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode cA = headA;
        ListNode cB = headB;

        while (cA != cB) {
            cA = (cA == null) ? headB : cA.next;
            cB = (cB == null) ? headA : cB.next;
        }

        return cA;
    }
}