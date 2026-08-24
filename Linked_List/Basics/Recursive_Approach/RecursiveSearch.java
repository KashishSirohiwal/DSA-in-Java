// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class RecursiveSearch {

    // Recursive function to check if target exists in the list.
    public static boolean contains(Node head, int target) {
        // Base case: empty list → target not found.
        if (head == null) {
            return false;
        }

        // If current node matches target, terminate early.
        if (head.data == target) {
            return true;
        }

        // Otherwise, search in the rest of the list.
        return contains(head.next, target);
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
        System.out.println("Contains 15? " + contains(head, 15));   // true
        System.out.println("Contains 100? " + contains(head, 100)); // false
    }
}