class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class IntersectionOfLinkedLists {

    public static Node getIntersectionNode(Node headA, Node headB) {

        // If either Linked List is empty, intersection is impossible.
        if (headA == null || headB == null) {
            return null;
        }

        Node currentA = headA;
        Node currentB = headB;

        /*
         * Traverse both lists simultaneously.
         *
         * When currentA reaches the end of List A,
         * redirect it to the head of List B.
         *
         * When currentB reaches the end of List B,
         * redirect it to the head of List A.
         *
         * Therefore, both pointers effectively traverse:
         *
         * currentA: A → B
         * currentB: B → A
         *
         * This compensates for any difference in the lengths
         * of the two lists before their intersection.
         */
        while (currentA != currentB) {

            if (currentA == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }

            if (currentB == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }

        /*
         * Two possibilities:
         *
         * 1. Both references point to the same Node object.
         *    → Intersection found, return that Node.
         *
         * 2. Both references become null.
         *    → Lists do not intersect, return null.
         */
        return currentA;
    }

    public static void main(String[] args) {

        // Shared common part
        Node common1 = new Node(7);
        Node common2 = new Node(8);
        Node common3 = new Node(9);

        common1.next = common2;
        common2.next = common3;

        // List A
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common1;

        // List B
        Node headB = new Node(4);
        headB.next = new Node(5);
        headB.next.next = common1;

        // Find the actual intersection Node.
        Node intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node: " + intersection.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}