/*
Method : Two Pointer Approach using current and previous pointer

Steps:
1. Create a new node with the given data.
2. If the position is 0, set the new node's next to the current head and return the new node as the new head.
3. Initialize two pointers, current and previous, to traverse the linked list.
4. Move the current pointer to the desired position while keeping track of the previous node.
5. If the current pointer is null, it means the position is greater than the length of the list, so return the original head.
6. Set the new node's next to the current node and the previous node's next to the new node.

Time Complexity: O(n), where n is the number of nodes in the linked list. In the worst case, we may need to traverse the entire list to reach the desired position.
Space Complexity: O(1), as we are using a constant amount of extra space for the new node and pointers.
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtPosition {
    public static Node insertAtPosition(Node head, int data, int position) {
        if (position < 0) {
            // Invalid position
            return head;
        }

        if (position == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            // Position is greater than the length of the list
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        // Example usage:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head = insertAtPosition(head, 4, 2); // 1 -> 2 -> 4 -> 3
        head = insertAtPosition(head, 5, 0); // 5 -> 1 -> 2 -> 4 -> 3

        // Print the updated linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }     
    }
}