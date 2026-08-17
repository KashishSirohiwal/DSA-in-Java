class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class LinkedListPalindromeCheck {

    public static boolean isPalindrome(Node head) {

        // An empty or one-Node Linked List is always a palindrome.
        if (head == null || head.next == null) {
            return true;
        }

        /*
         * Step 1: Find the middle of the Linked List.
         *
         * slow moves one step at a time.
         * fast moves two steps at a time.
         */
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * For an odd-length list, slow is sitting on the middle Node, which should not be compared.
         * Skip the middle Node.
         */
        if (fast != null) {
            slow = slow.next;
        }

        /*
         * Step 2: Reverse the second half.
         *
         * After reversal, previous becomes the head of the reversed second half.
         */
        Node previous = null;
        Node current = slow;

        while (current != null) {

            // Save the next Node before changing current.next.
            Node next = current.next;

            // Reverse the current Node's link.
            current.next = previous;

            // Move previous forward.
            previous = current;

            // Move current forward using the saved reference.
            current = next;
        }

        /*
         * Step 3: Compare the first half with
         * the reversed second half.
         */
        Node first = head;
        Node second = previous;

        while (second != null) {

            // Corresponding Nodes must contain equal data.
            if (first.data != second.data) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        // Every corresponding Node matched.
        return true;
    }

    public static void main(String[] args) {

        // Creating:
        // 1 → 2 → 3 → 2 → 1 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }
}