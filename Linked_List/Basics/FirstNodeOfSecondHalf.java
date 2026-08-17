class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class FirstNodeOfSecondHalf {

    public static Node firstNodeOfSecondHalf(Node head) {

        // Empty or one-Node list has no separate second half
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next;

        /*
         * slow moves one step at a time.
         * fast moves two steps at a time.
         *
         * Starting fast at head.next allows us to
         * distinguish odd and even-sized lists after
         * the traversal.
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * Odd number of Nodes:
         * fast becomes null.
         * slow itself is the first Node of the second half.
         */
        if (fast == null) {
            return slow;
        }

        /*
         * Even number of Nodes:
         * slow is the last Node of the first half,
         * so slow.next is the first Node of the second half.
         */
        return slow.next;
    }

    public static void main(String[] args) {

        // Creating:
        // 1 → 2 → 3 → 4 → 5 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Find the first Node of the second half
        Node firstNode = firstNodeOfSecondHalf(head);

        // Display the second half
        Node current = firstNode;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}