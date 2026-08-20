class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class ReverseKGroups {

    public static Node reverseKGroups(Node head, int k) {

        // Handle an empty list or invalid group size.
        if (head == null || k <= 1) {
            return head;
        }

        Node current = head;

        // Stores the tail of the previously reversed group.
        Node previousGroupTail = null;

        // The new head will be determined after reversing the first group.
        Node newHead = null;

        while (current != null) {

            /*
             * Check whether at least k Nodes are available
             * starting from the current group.
             */
            Node afterGroup = current;

            for (int i = 0; i < k; i++) {

                // Not enough Nodes for a complete group.
                if (afterGroup == null) {
                    return newHead;
                }

                afterGroup = afterGroup.next;
            }

            /*
             * The original first Node of the group becomes
             * the tail after reversal.
             */
            Node newGroupTail = current;

            /*
             * Start the reversal.
             *
             * previous initially points to afterGroup so that
             * the tail of the reversed group automatically
             * connects to the untouched portion.
             */
            Node previous = afterGroup;

            // Reverse exactly k Nodes.
            for (int i = 0; i < k; i++) {

                // Save the next Node before modifying current.next.
                Node next = current.next;

                // Reverse the current Node's link.
                current.next = previous;

                // Move previous forward.
                previous = current;

                // Move current to the next unreversed Node.
                current = next;
            }

            /*
             * After reversal:
             *
             * previous → new head of current group
             * newGroupTail → new tail of current group
             */
            Node newGroupHead = previous;

            /*
             * The first reversed group becomes the new head
             * of the entire Linked List.
             */
            if (newHead == null) {
                newHead = newGroupHead;
            } else {
                /*
                 * Connect the previous reversed group's tail
                 * to the current reversed group's head.
                 */
                previousGroupTail.next = newGroupHead;
            }

            // Current group's tail becomes the previous group's tail
            // for the next iteration.
            previousGroupTail = newGroupTail;
        }

        return newHead;
    }

    public static void main(String[] args) {

        // Creating:
        // 1 → 2 → 3 → 4 → 5 → 6 → 7 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        int k = 3;

        // Reverse Nodes in groups of k.
        head = reverseKGroups(head, k);

        // Display the final Linked List.
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}