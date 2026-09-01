class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class RemoveFirstOccurrence {

    // Recursive function to remove the first occurrence of target
    public static Node removeFirstOccurrence(Node head, int target) {
        // Case 1: empty list → nothing to remove
        if (head == null) {
            return null;
        }

        // Case 2: current node matches target → drop it
        if (head.data == target) {
            return head.next;
        }

        // Case 3: recurse forward
        head.next = removeFirstOccurrence(head.next, target);
        return head;
    }

    public static void main(String[] args) {
        // Example list: 10 → 20 → 30 → 10 → null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(10);

        // Remove the first occurrence of 10
        head = removeFirstOccurrence(head, 10);

        // Print the modified list
        Node curr = head;
        System.out.print("Modified list: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        // Output: Modified list: 20 30 10
    }
}