class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class ReverseBetweenRecursive {

    private static Node successor = null;

    // Reverse first n nodes
    private static Node reverseN(Node head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        Node newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }

    // Reverse between left and right
    public static Node reverseBetween(Node head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseBetween(head, 2, 4);

        Node curr = head;
        System.out.print("Modified list: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        // Output: Modified list: 1 4 3 2 5
    }
}