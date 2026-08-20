public static Node reverseFirstKNodes(Node head, int k) {

    // Handle an empty list or invalid k.
    if (head == null || k <= 0) {
        return head;
    }

    // Find the Node immediately after the first k Nodes.
    Node afterK = head;

    for (int i = 0; i < k; i++) {

        // If k is greater than the length of the list,
        // the requested reversal cannot be completed.
        if (afterK == null) {
            return head;
        }

        afterK = afterK.next;
    }

    /*
     * Start previous at afterK.
     *
     * This is the key idea:
     * the original head will become the tail of the
     * reversed portion, so its next reference should
     * eventually point to afterK.
     */
    Node previous = afterK;
    Node current = head;

    // Reverse exactly k Nodes.
    for (int i = 0; i < k; i++) {

        // Save the next Node before modifying current.next.
        Node next = current.next;

        // Reverse the current Node's link.
        current.next = previous;

        // Move previous forward.
        previous = current;

        // Move current forward.
        current = next;
    }

    // Previous is now the new head of the reversed portion.
    return previous;
}