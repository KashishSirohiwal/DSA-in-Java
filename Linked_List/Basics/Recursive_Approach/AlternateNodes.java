class Node {
    int data;   // Stores the value of the node.
    Node next;  // Pointer to the next node in the list.

    // Constructor to initialize a node with a given value.
    Node(int value) {
        data = value;
    }
}

public class AlternateNodes {

    // Recursive function to print alternate nodes of the linked list.
    public static void printAlternate(Node head) {
        // Base case: if the list is empty, stop recursion.
        if (head == null) {
            return;
        }

        // Print the current node’s data.
        System.out.print(head.data + " ");

        // Skip one node and recursively call for the next alternate node.
        // head.next.next ensures we move two steps forward.
        printAlternate(head.next.next);
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

        // Print alternate nodes starting from head.
        // Output will be: 1 3 5
        printAlternate(head);
    }
}