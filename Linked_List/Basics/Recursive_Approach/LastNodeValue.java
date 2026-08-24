// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    // Constructor to initialize a node with a given value.
    Node(int value) {
        data = value;
    }
}

public class LastNodeValue {

    // Recursive function to find the last node's value.
    public static int findLast(Node head) {
        // Base case: if the list is empty, return 0.
        if (head == null) {
            return 0;
        }

        // If this is the last node (next == null), return its value.
        if (head.next == null) {
            return head.data;
        }

        // Otherwise, keep moving forward recursively.
        return findLast(head.next);
    }

    public static void main(String[] args) {
        // Example list: -5 → 10 → -3 → null
        Node head = new Node(-5);
        Node node2 = new Node(10);
        Node node3 = new Node(-3);

        head.next = node2;
        node2.next = node3;
        node3.next = null;

        // Find the last node's value.
        int lastValue = findLast(head);

        // Print the last node's value.
        // Output will be: Last node value: -3
        System.out.println("Last node value: " + lastValue);

        // Example with empty list:
        Node emptyHead = null;
        System.out.println("Empty list last value: " + findLast(emptyHead));
        // Output will be: Empty list last value: 0
    }
}