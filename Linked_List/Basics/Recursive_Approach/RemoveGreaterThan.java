// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class RemoveGreaterThan {

    // Recursive function to remove all nodes with values greater than x.
    public static Node removeGreaterThan(Node head, int x) {
        // Base case: empty list → nothing to remove.
        if (head == null) {
            return null;
        }

        // Recursively clean the remainder of the list first.
        head.next = removeGreaterThan(head.next, x);

        // If current node’s value is greater than x, drop it.
        if (head.data > x) {
            return head.next; // skip this node
        }

        // Otherwise, keep current node.
        return head;
    }

    public static void main(String[] args) {
        // Example list: 1 → 5 → 2 → 7 → 3 → null
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(3);

        // Remove all nodes greater than 3.
        head = removeGreaterThan(head, 3);

        // Print the modified list.
        Node current = head;
        System.out.print("Modified list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        // Output: Modified list: 1 2 3
    }
}