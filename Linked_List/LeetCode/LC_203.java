class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}