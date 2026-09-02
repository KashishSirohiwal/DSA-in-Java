class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class RecursiveReverseLinkedList {

    // Recursive function to reverse a linked list
    public static Node reverse(Node head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        Node newHead = reverse(head.next);

        // Attach current node at the end of the reversed sublist
        head.next.next = head;

        // Break the old link to avoid cycle
        head.next = null;

        // Return the new head of the reversed list
        return newHead;
    }

    public static void main(String[] args) {
        // Example: 1 → 2 → 3 → 4 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Reverse the list
        head = reverse(head);

        // Print reversed list: 4 → 3 → 2 → 1
        Node curr = head;
        System.out.print("Reversed list: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}