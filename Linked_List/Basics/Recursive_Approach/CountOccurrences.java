// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class CountOccurrences {

    // Recursive function to count how many times target appears in the list.
    public static int countOccurrences(Node head, int target) {
        // Base case: empty list → no occurrences.
        if (head == null) {
            return 0;
        }

        // If current node matches target, add 1 and recurse further.
        if (head.data == target) {
            return 1 + countOccurrences(head.next, target);
        }

        // Otherwise, skip this node and recurse further.
        return countOccurrences(head.next, target);
    }

    public static void main(String[] args) {
        // Example list: 4 → 8 → 15 → 16 → 23 → 42 → 15 → null
        Node head = new Node(4);
        head.next = new Node(8);
        head.next.next = new Node(15);
        head.next.next.next = new Node(16);
        head.next.next.next.next = new Node(23);
        head.next.next.next.next.next = new Node(42);
        head.next.next.next.next.next.next = new Node(15);

        // Test cases
        System.out.println("Occurrences of 15: " + countOccurrences(head, 15));   // 2
        System.out.println("Occurrences of 100: " + countOccurrences(head, 100)); // 0
    }
}