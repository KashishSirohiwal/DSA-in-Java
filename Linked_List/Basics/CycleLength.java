class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class CycleLength {

    public static int cycleLength(Node head) {

        // Detect whether a cycle exists.
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            // Slow moves one Node at a time.
            slow = slow.next;

            // Fast moves two Nodes at a time.
            fast = fast.next.next;

            // If both references meet, a cycle exists.
            if (slow == fast) {
                break;
            }
        }

        // If fast reached the end, there is no cycle.
        if (fast == null || fast.next == null) {
            return 0;
        }

        /*
         * A cycle exists.
         * Start from the meeting Node and traverse
         * the cycle once while counting each Node.
         */
        Node current = slow;
        int count = 0;

        do {
            count++;
            current = current.next;
        } while (current != slow);

        return count;
    }

    public static void main(String[] args) {
        // Creating:
        // 1 → 2 → 3 → 4 → 5 → 6
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // Create a cycle:
        // 6 → 3
        node6.next = node3;

        // Find the number of Nodes in the cycle.
        int n = cycleLength(head);

        if (n != 0) {
            System.out.println("Cycle length : " + n);
        } else {
            System.out.println("No cycle exists.");
        }
    }
}