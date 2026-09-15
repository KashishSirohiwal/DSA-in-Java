/*
Problem: 2130. Maximum Twin Sum of a Linked List

Method: Two Pointers + Reverse the second half of the linked list

Steps:
1. Use the slow and fast pointer technique to find the middle of the linked list.
2. Reverse the second half of the linked list starting from the middle node.
3. Initialize two pointers, one at the head of the linked list and the other at the head of the reversed second half.
4. Iterate through both halves of the linked list simultaneously, calculating the sum of the values at the two pointers and updating the maximum sum found.
5. Return the maximum twin sum found.

Time Complexity: O(n) where n is the number of nodes in the linked list.
Space Complexity: O(1) since we are reversing the linked list in place and using a
*/

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        // Find the middle of the linked list using the slow and fast pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow, previous = null;

        // Reverse the second half of the linked list
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        int maxSum = 0;
        ListNode first = head, second = previous;

        // Calculate the maximum twin sum by iterating through the first half and the reversed second half of the linked list
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}