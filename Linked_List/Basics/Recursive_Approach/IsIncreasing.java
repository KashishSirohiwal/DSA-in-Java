 // Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class StrictlyIncreasingList {

    // Recursive function to check if the list is strictly increasing.
    public static boolean isStrictlyIncreasing(Node head) {
        // Base case: empty list or single node → considered strictly increasing.
        if (head == null || head.next == null) {
            return true;
        }

        // If current node is not less than the next node, fail immediately.
        if (head.data >= head.next.data) {
            return false;
        }

        // Otherwise, check the rest of the list.
        return isStrictlyIncreasing(head.next);
    }

    public static void main(String[] args) {
        // Example list: 4 → 8 → 15 → 16 → 23 → 42 → null
        Node head = new Node(4);
        head.next = new Node(8);
        head.next.next = new Node(15);
        head.next.next.next = new Node(16);
        head.next.next.next.next = new Node(23);
        head.next.next.next.next.next = new Node(42);

        // Test cases
        System.out.println("Is strictly increasing? " + isStrictlyIncreasing(head)); // true

        // Example with violation: 10 → 20 → 15 → null
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(15);

        System.out.println("Is strictly increasing? " + isStrictlyIncreasing(head2)); // false
    }
}