// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class CountGreaterThan {

    // Recursive function to count nodes with values greater than a threshold.
    public static int countGreater(Node head, int threshold) {
        // Base case: empty list → no nodes.
        if (head == null) {
            return 0;
        }

        // If current node’s value is greater, count it + recurse further.
        if (head.data > threshold) {
            return 1 + countGreater(head.next, threshold);
        }

        // Otherwise, skip this node and recurse further.
        return countGreater(head.next, threshold);
    }

    public static void main(String[] args) {
        // Example list: 4 → 8 → 15 → 16 → 23 → 42 → null
        Node head = new Node(4);
        head.next = new Node(8);
        head.next.next = new Node(15);
        head.next.next.next = new Node(16);
        head.next.next.next.next = new Node(23);
        head.next.next.next.next.next = new Node(42);

        // Count nodes greater than 20.
        int count = countGreater(head, 20);

        // Output will be: 2 (nodes 23 and 42)
        System.out.println("Nodes greater than 20: " + count);

        // Count nodes greater than 10.
        int count2 = countGreater(head, 10);

        // Output will be: 4 (nodes 15, 16, 23, 42)
        System.out.println("Nodes greater than 10: " + count2);
    }
}