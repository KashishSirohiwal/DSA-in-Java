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

    // Recursive function to find the minimum value in the linked list.
    public static int findMin(Node head) {
        // Base case: if the list is empty, return Integer.MAX_VALUE
        // so it won't affect comparisons.
        if (head == null) {
            return Integer.MAX_VALUE;
        }

        // Recursively find the minimum in the rest of the list.
        int minInRest = findMin(head.next);

        // Compare current node’s data with minimum of the rest.
        return Math.min(head.data, minInRest);
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

        // Call the recursive function to find minimum.
        int minValue = findMin(head);

        // Print the maximum value in the linked list.
        // Output will be: Minimum value in Linked List: 10
        System.out.println("Minimum value in Linked List: " + minValue);
    }
}