class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class ReverseLinkedList {
    public static Node reverseList(Node head) {

        // Previous Node initially points to null because
        // the original head will become the new tail.
        Node previous = null;

        // Current Node starts from the head.
        Node current = head;

        while (current != null) {

            // Save the next Node before changing current.next.
            // This prevents losing access to the remaining list.
            Node next = current.next;

            // Reverse the link of the current Node.
            current.next = previous;

            // Move previous one Node forward.
            previous = current;

            // Move current to the next unreversed Node.
            current = next;
        }

        // Previous now refers to the new head of the reversed list.
        return previous;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Reverse the Linked List.
        head = reverseList(head);

        // Display the reversed Linked List.
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}