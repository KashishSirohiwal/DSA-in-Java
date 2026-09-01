class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class InsertAtEnd {

    // Recursive function to insert at the end
    public static Node insertEnd(Node head, int value) {
        // Base case: empty list → new node becomes head
        if (head == null) {
            return new Node(value);
        }

        // If this is the last node, attach the new node
        if (head.next == null) {
            head.next = new Node(value);
            return head;
        }

        // Otherwise, recurse forward
        head.next = insertEnd(head.next, value);
        return head;
    }

    public static void main(String[] args) {
        // Example: 10 → 20 → 30 → null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        // Insert 40 at the end
        head = insertEnd(head, 40);

        // Print list: 10 → 20 → 30 → 40
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}