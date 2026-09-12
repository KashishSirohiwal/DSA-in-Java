public class LC_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next node
            }
        }
        return head;
    }
}