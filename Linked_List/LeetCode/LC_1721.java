/*
Problem : LC 1721. Swapping Nodes in a Linked List

Method : Two Pointer Approach using slow and fast pointer

Steps :
1. Initialize two pointers, fast and slow, to the head of the linked list.
2. Move the fast pointer k-1 steps forward to reach the k-th node from the beginning.
3. Store the reference to this k-th node in a variable called first.
4. Continue moving the fast pointer to the end of the list while simultaneously moving the slow pointer one step at a time.
5. When the fast pointer reaches the end, the slow pointer will be at the k-th
    node from the end. Store this reference in a variable called second.
6. Swap the values of the first and second nodes.

Time Complexity : O(n) where n is the number of nodes in the linked list.
Space Complexity : O(1) since we are using a constant amount of extra space.
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        // Step 1: move fast to k-th node
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        ListNode first = fast; // k-th node from the beginning

        // Step 2: move fast to the end, and slow to the k-th node from the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode second = slow; // k-th node from the end

        // Step 3: swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}