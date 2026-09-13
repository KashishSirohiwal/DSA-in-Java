/*
Problem: 142. Linked List Cycle II

Method: Floyd's Cycle Detection Algorithm (Slow and Fast Pointer Technique)

Steps:
1. Initialize two pointers, slow and fast, both starting at the head of the linked list
2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
3. If there is a cycle in the linked list, the fast pointer will eventually meet the slow pointer.
4. If the fast pointer reaches the end of the list (null), then there is no cycle.

Time Complexity: O(n) - In the worst case, we traverse the entire linked list once.
Space Complexity: O(1) - We use a constant amount of space for the two pointers.
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}