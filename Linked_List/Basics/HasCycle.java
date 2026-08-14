package Linked_List.Basics;

/*
Time Complexity:  O(n)
Space Complexity: O(1)
*/

public class HasCycle {

    // Detects whether a Linked List contains a cycle
    // using Floyd's Fast and Slow Reference technique.
    public static boolean hasCycle(Node head) {

        // Both references start from the head.
        Node slow = head;
        Node fast = head;

        // Continue while fast can safely move two Nodes.
        // If fast reaches null, the list has no cycle.
        while (fast != null && fast.next != null) {

            // Slow moves one Node at a time.
            slow = slow.next;

            // Fast moves two Nodes at a time.
            fast = fast.next.next;

            // If both references point to the same Node,
            // they have met inside a cycle.
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end of the list,
        // so no cycle exists.
        return false;
    }
}