// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class FirstOccurrence {

    // Recursive function to find the first occurrence of target.
    // Returns the index (0-based) or -1 if not found.
    public static int firstOccurrence(Node head, int target) {
        // Base case: empty list → target not found.
        if (head == null) {
            return -1;
        }

        // If current node matches target, return 0 (this position).
        if (head.data == target) {
            return 0;
        }

        // Otherwise, search in the rest of the list.
        int indexInRest = firstOccurrence(head.next, target);

        // If not found in rest, propagate -1.
        if (indexInRest == -1) {
            return -1;
        }

        // Otherwise, add 1 to the index from the rest.
        return 1 + indexInRest;
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
        System.out.println("First occurrence of 15: " + firstOccurrence(head, 15));   // 2
        System.out.println("First occurrence of 100: " + firstOccurrence(head, 100)); // -1
    }
}