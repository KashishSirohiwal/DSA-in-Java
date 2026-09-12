/*
Problem: 876. Middle of the Linked List

Method: Two Pointers (Slow and Fast)

Time Complexity: O(n) - We traverse the linked list once, where n is the number of nodes in the list.
Space Complexity: O(1) - We use a constant amount of space for the two pointers.
*/

public class LC_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2
        }
        return slow; // Slow pointer will be at the middle node
    }
}