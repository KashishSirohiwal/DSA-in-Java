/*
Problem : LC_19. Remove Nth Node From End of List

Method: Two Pointer Technique (Slow and Fast Pointer)

Steps:
1. Create a dummy node and point its next to the head of the linked list.
2. Initialize two pointers, slow and fast, both pointing to the dummy node.
3. Move the fast pointer n + 1 steps ahead to create a gap of n nodes between slow and fast.
4. Move both pointers one step at a time until the fast pointer reaches the end of the list.
5. The slow pointer will be pointing to the node just before the target node (the nth
    node from the end). Update the next pointer of the slow node to skip the target node.

Time Complexity: O(n) - We traverse the linked list once, where n is the number of nodes in the list.
Space Complexity: O(1) - We use a constant amount of space for the pointers.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n + 1; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}