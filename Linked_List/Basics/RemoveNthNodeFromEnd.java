class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class RemoveNthNodeFromEnd {
    public static Node removeNthNodeFromEnd(Node head, int n) {

        // Dummy node is placed before the actual head.
        // It allows us to handle head deletion without a separate case.
        Node dummy = new Node(0);
        dummy.next = head;

        // Both references initially point to the dummy node.
        Node slow = dummy;
        Node fast = dummy;

        // Create a gap of n + 1 nodes between slow and fast.
        // This ensures that slow stops at the node immediately
        // before the node that needs to be removed.
        for (int i = 0; i < n + 1; i++) {

            // If fast becomes null before completing n + 1 moves,
            // then n is greater than the length of the list.
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        // Move both references at the same speed.
        // When fast reaches null, slow is at the predecessor
        // of the n-th node from the end.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Bypass the node that needs to be removed.
        // slow.next is the target node.
        slow.next = slow.next.next;

        // dummy.next is the new head of the modified list.
        return dummy.next;
    }

    public static void main(String[] args) {

        // Creating the linked list:
        // 5 → 10 → 15 → 20 → 25
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(25);

        int n = 2;

        // Remove the 2nd node from the end.
        // The 2nd node from the end is 20.
        head = removeNthNodeFromEnd(head, n);

        // Display the modified linked list.
        System.out.print("Linked List after removing the "
                + n + "th node from the end: ");

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}