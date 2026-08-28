// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class IdenticalLists {

    // Recursive function to check if two lists are identical.
    public static boolean areIdentical(Node head1, Node head2) {
        // Base case: both lists empty → identical.
        if (head1 == null && head2 == null) {
            return true;
        }

        // If one is empty and the other isn’t → not identical.
        if (head1 == null || head2 == null) {
            return false;
        }

        // If current node values differ → not identical.
        if (head1.data != head2.data) {
            return false;
        }

        // Otherwise, check the rest of the lists.
        return areIdentical(head1.next, head2.next);
    }

    public static void main(String[] args) {
        // First list: 4 → 8 → 15 → 16 → 23 → 42 → null
        Node head1 = new Node(4);
        head1.next = new Node(8);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(16);
        head1.next.next.next.next = new Node(23);
        head1.next.next.next.next.next = new Node(42);

        // Second list: 4 → 8 → 15 → 16 → 23 → 42 → null
        Node head2 = new Node(4);
        head2.next = new Node(8);
        head2.next.next = new Node(15);
        head2.next.next.next = new Node(16);
        head2.next.next.next.next = new Node(23);
        head2.next.next.next.next.next = new Node(42);

        // Third list: 4 → 8 → 15 → 99 → null
        Node head3 = new Node(4);
        head3.next = new Node(8);
        head3.next.next = new Node(15);
        head3.next.next.next = new Node(99);

        // Test cases
        System.out.println("List1 vs List2 identical? " + areIdentical(head1, head2)); // true
        System.out.println("List1 vs List3 identical? " + areIdentical(head1, head3)); // false
    }
}