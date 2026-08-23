class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    // Constructor to initialize a node with a given value.
    Node(int value) {
        data = value;
    }
}

public class LinkedListLength {

    // Recursive function to calculate the length of the linked list.
    public static int printLength(Node head) {
        // Base case: if the list is empty, return 0.
        if (head == null) {
            return 0;
        }

        // For each node, add 1 and move to the next node.
        // Recursion continues until head becomes null.
        return 1 + printLength(head.next);
    }

    public static void main(String[] args) {
        // Create nodes with values 1 to 6.
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        // Call the recursive function to calculate length.
        int length = printLength(head);

        // Print the length of the linked list.
        // Output will be: 6
        System.out.println("Length of Linked List: " + length);
    }
}