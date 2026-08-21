class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class OddNodesByEvenNodes {

    public static Node oddNodesByEvenNodes(Node head) {

        // Empty list or single-Node list needs no rearrangement.
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * oddHead always points to the first odd-position Node.
         * evenHead always points to the first even-position Node.
         *
         * These references never change.
         */
        Node oddHead = head;
        Node evenHead = head.next;

        /*
         * oddTail tracks the last Node in the odd-position chain.
         * evenTail tracks the last Node in the even-position chain.
         */
        Node oddTail = oddHead;
        Node evenTail = evenHead;

        /*
         * Continue while an even-position Node exists.
         *
         * Each iteration connects:
         *
         * oddTail → next odd Node
         * evenTail → next even Node
         */
        while (evenTail != null && evenTail.next != null) {

            // Connect the current odd Node to the next odd-position Node.
            oddTail.next = oddTail.next.next;

            // Move oddTail to the newly added odd-position Node.
            oddTail = oddTail.next;

            // Connect the current even Node to the next even-position Node.
            evenTail.next = evenTail.next.next;

            // Move evenTail to the newly added even-position Node.
            evenTail = evenTail.next;
        }

        /*
         * The odd-position chain must come before
         * the even-position chain.
         */
        oddTail.next = evenHead;

        return oddHead;
    }

    public static void main(String[] args) {

        // Creating:
        // 1 → 2 → 3 → 4 → 5 → 6 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        // Rearrange odd-position Nodes followed by even-position Nodes.
        head = oddNodesByEvenNodes(head);

        // Display the modified Linked List.
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}