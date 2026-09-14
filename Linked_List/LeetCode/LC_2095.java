/*
Problem : LC 2095. Delete the Middle Node of a Linked List

Method : Two Pointer Approach using slow and fast pointer

Steps :
1. Initialize slow and fast pointers to the head of the linked list.
2. Initialize a prev pointer to null, which will keep track of the node before the slow pointer.
3. Traverse the linked list using a while loop until the fast pointer reaches the end of the
    list or the node before the end (i.e., fast is null or fast.next is null).
4. Inside the loop, update the prev pointer to point to the slow pointer, move the slow pointer
    one step forward (slow = slow.next), and move the fast pointer two steps forward (fast = fast.next.next).
5. After the loop, check if prev is null. If it is, it means the linked list had only one node, so we return null (the list becomes empty).
6. If prev is not null, we bypass the middle node by setting prev.next to slow.next, effectively removing the middle node from the linked list.

Time Complexity : O(n) where n is the number of nodes in the linked list.
Space Complexity : O(1) since we are using a constant amount of extra space.
*/

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev == null) {
            head = slow.next;
        } else {
            prev.next = slow.next;
        }

        return head;
    }
}