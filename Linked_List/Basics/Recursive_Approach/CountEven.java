// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class CountCondition {

    // Recursive function to count nodes satisfying a condition.
    public static int countNodesGreaterThan(Node head, int threshold) {
        // Base case: empty list → no nodes.
        if (head == null) {
            return 0;
        }

        // Check if current node satisfies the condition.
        if (head.data > threshold) {
            // Count this node + recurse further.
            return 1 + countNodesGreaterThan(head.next, threshold);
        }

        // Otherwise, skip this node and recurse further.
        return countNodesGreaterThan(head.next, threshold);
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
        int count = countNodesGreaterThan(head, 20);

        // Output will be: 2 (nodes 23 and 42)
        System.out.println("Nodes greater than 20: " + count);
    }
}