/*
Problem: Merge Two Sorted Lists

Method: Iterative Approach

Steps:
1. Create a dummy node to serve as the starting point of the merged list.
2. Use a pointer (tail) to keep track of the last node in the merged list
3. Traverse both input lists (l1 and l2) simultaneously:
   - Compare the current nodes of both lists.
   - Append the smaller node to the merged list and move the corresponding pointer forward.

Time Complexity: O(n + m) - We traverse both linked lists once, where n and m are the number of nodes in the two lists.
Space Complexity: O(1) - We use a constant amount of space for the pointers.
*/

public class LC_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Traverse both lists and append the smaller value to the merged list
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1; // Append l1 node
                l1 = l1.next; // Move to the next node in l1
            } else {
                tail.next = l2; // Append l2 node
                l2 = l2.next; // Move to the next node in l2
            }
            tail = tail.next; // Move to the next node in the merged list
        }

        // If there are remaining nodes in either list, append them
        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }
}