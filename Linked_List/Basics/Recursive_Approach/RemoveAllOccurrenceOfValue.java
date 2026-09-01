// Node class represents each element in the linked list.
class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class RemoveAllOccurrences {

    // Recursive function to remove all occurrences of target.
    public static Node removeAll(Node head, int target) {
        // Base case: empty list → nothing to remove.
        if (head == null) {
            return null;
        }

        // Recursively clean the remainder of the list.
        head.next = removeAll(head.next, target);

        // If current node matches target, skip it.
        if (head.data == target) {
            return head.next; // drop current node
        }

        // Otherwise, keep current node.
        return head;
    }

    public static void main(String[] args) {
        // Example list: 1 → 2 → 3 → 2 → 4 → 2 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(2);

        // Remove all occurrences of 2.
        head = removeAll(head, 2);

        // Print the modified list.
        Node current = head;
        System.out.print("Modified list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        // Output: Modified list: 1 3 4
    }
}