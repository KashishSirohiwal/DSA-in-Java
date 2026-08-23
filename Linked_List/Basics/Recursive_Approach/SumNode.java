// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    // Constructor to initialize a node with a given value.
    Node(int value) {
        data = value;
    }
}

public class SumNode {

    // Recursive function to calculate the sum of all nodes in the linked list.
    public static int printSum(Node head) {
        // Base case: if the list is empty, return 0.
        if (head == null) {
            return 0;
        }

        // Add the current node’s data to the sum of the remaining list.
        return head.data + printSum(head.next);
    }

    public static void main(String[] args) {
        // Create nodes with values 1 to 6.
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // Link nodes together to form the list: 1 → 2 → 3 → 4 → 5 → 6
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null; // Last node points to null.

        // Call the recursive function to calculate the sum.
        int sum = printSum(head);

        // Print the sum of the linked list.
        // Output will be: Sum of Linked List: 21
        System.out.println("Sum of Linked List: " + sum);
    }
}