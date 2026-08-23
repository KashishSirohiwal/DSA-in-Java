// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    // Constructor to initialize a node with a given value.
    Node(int value) {
        data = value;
    }
}

public class MaxNode {

    // Recursive function to find the maximum value in the linked list.
    public static int findMax(Node head) {
        // Base case: if the list is empty, return Integer.MIN_VALUE
        // so it won't affect comparisons.
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        // Recursively find the maximum in the rest of the list.
        int maxInRest = findMax(head.next);

        // Compare current node’s data with maximum of the rest.
        return Math.max(head.data, maxInRest);
    }

    public static void main(String[] args) {
        // Example with negative and positive values: -5 → 10 → -3 → null
        Node head = new Node(-5);
        Node node2 = new Node(10);
        Node node3 = new Node(-3);

        // Link nodes together
        head.next = node2;
        node2.next = node3;
        node3.next = null;

        // Call the recursive function to find maximum.
        int maxValue = findMax(head);

        // Print the maximum value in the linked list.
        // Output will be: Maximum value in Linked List: 10
        System.out.println("Maximum value in Linked List: " + maxValue);
    }
}