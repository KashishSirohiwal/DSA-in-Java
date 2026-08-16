
class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class RemoveKthNodeFromStart {
    public static Node removeKthNodeFromStart(Node head, int k) {

        Node current = head;
        Node prev = null;
        int pos = 1;

        // Traverse until we find the K-th Node
        while (current != null) {

            if (pos == k) {

                // Case 1: K-th Node is the head
                if (prev == null) {
                    head = current.next;
                }

                // Case 2: K-th Node is middle or tail
                else {
                    prev.next = current.next;
                }

                // Only one Node needs to be removed
                break;
            }

            // Move prev only when current is not being removed
            prev = current;
            current = current.next;
            pos++;
        }

        // If k is invalid, the original head is returned unchanged
        return head;
    }

    public static void main(String[] args) {

        // Creating:
        // 1 → 2 → 3 → 4 → 5 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 3;

        // Remove the 3rd Node from the beginning
        head = removeKthNodeFromStart(head, k);

        // Display the modified Linked List
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}