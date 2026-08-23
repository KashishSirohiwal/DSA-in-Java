class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    Node(int value) {
        data = value;
    }
}

public class LinkedListReverse {

    // Recursive function to print the linked list in reverse order.
    public static void printReverse(Node head) {
        // Base case: if the list is empty, stop recursion.
        if (head == null) {
            return;
        }

        // Recursive call: move to the next node before printing.
        printReverse(head.next);

        // Print the data after recursive calls unwind.
        // This ensures nodes are printed in reverse order.
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        // Create nodes with values 1 to 6.
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
        node6.next = null;

        // Print the linked list in reverse order using recursion.
        // Output will be: 6 5 4 3 2 1
        printReverse(head);
    }
}
