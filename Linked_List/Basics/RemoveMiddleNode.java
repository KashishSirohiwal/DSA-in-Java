class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class RemoveMiddleNode {

    public static Node removeMiddleNode(Node head) {

        // Handle an empty Linked List
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        /*
         * slow moves one step at a time,
         * fast moves two steps at a time.
         *
         * prev always stores the Node immediately
         * before slow, so that the middle Node can
         * be removed once slow reaches it.
         *
         * For an even-length list, this standard
         * initialization selects the second middle Node.
        */
        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * If prev is null, the list contained only
         * one Node. Therefore, slow is the head and
         * removing it makes the list empty.
        */
        if (prev == null) {
            head = slow.next;
        } else {
            /*
             * Bypass the middle Node by connecting
             * its predecessor directly to its successor.
             */
            prev.next = slow.next;
        }

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

        // Remove the middle Node
        head = removeMiddleNode(head);

        // Display the modified Linked List
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}