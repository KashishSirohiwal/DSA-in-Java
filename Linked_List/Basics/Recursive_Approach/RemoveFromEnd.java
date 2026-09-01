class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class RemoveFromEnd {

    // Recursive function to remove the last node
    public static Node removeFromEnd(Node head) {
        // Case 1: empty list → nothing to remove
        if (head == null) {
            return null;
        }

        // Case 2: single node → remove it by returning null
        if (head.next == null) {
            return null;
        }

        // Case 3: recurse forward until the last node
        head.next = removeFromEnd(head.next);
        return head;
    }

    public static void main(String[] args) {
        // Example: 10 → 20 → 30 → null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        // Remove last node
        head = removeFromEnd(head);

        // Print list: 10 → 20
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}