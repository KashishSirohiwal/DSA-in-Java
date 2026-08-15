class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class DetectCycleStart {

    // Returns the Node where the cycle begins.
    // Returns null if the Linked List does not contain a cycle.
    public static Node detectCycle(Node head) {

        // Phase 1: Detect whether a cycle exists.
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
            return null;
        }

        // Phase 2: Find the starting Node of the cycle.
        // Reset slow to the head while fast remains at the meeting point.
        slow = head;

        // Move both references one Node at a time.
        // Their next meeting point is the cycle's starting Node.
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
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

        // Create the cycle:
        node6.next = node3;

        // Detect the starting Node of the cycle.
        Node cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at Node: " + cycleStart.data);
        } else {
            System.out.println("No cycle exists.");
        }
    }
}