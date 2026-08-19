class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

// Stores both the head and tail of the Linked List.
class ListResult {
    Node head;
    Node tail;

    ListResult(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
}

public class ReverseWithHeadAndTail {

    public static ListResult reverseList(Node head) {

        // Empty Linked List: both head and tail are null.
        if (head == null) {
            return new ListResult(null, null);
        }

        /*
         * The original head becomes the new tail
         * after the Linked List is reversed.
         */
        Node newTail = head;

        // Standard Linked List reversal references.
        Node previous = null;
        Node current = head;

        while (current != null) {

            // Save the next Node before changing current.next.
            Node next = current.next;

            // Reverse the current Node's link.
            current.next = previous;

            // Move previous to the current Node.
            previous = current;

            // Move current to the next unreversed Node.
            current = next;
        }

        /*
         * After reversal:
         *
         * previous → new head
         * newTail  → original head
         */
        Node newHead = previous;

        // Return both the new head and new tail.
        return new ListResult(newHead, newTail);
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Reverse the Linked List.
        ListResult result = reverseList(head);

        // Retrieve the new head and tail.
        head = result.head;
        Node tail = result.tail;

        // Display the reversed Linked List.
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();

        // Display the new head and tail.
        System.out.println("New Head: " + head.data);
        System.out.println("New Tail: " + tail.data);
    }
}