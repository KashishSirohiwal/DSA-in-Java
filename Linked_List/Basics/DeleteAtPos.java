package Linked_List.Basics;

/*
Objective:
Delete a node at a specific position in a linked list.

Key Steps:
• Traverse the linked list while keeping track of the current node and its previous node.
• If the current position matches the target index, update the previous node's next pointer to skip the current node, effectively removing it from the list.
• If the target index is 0, update the head to point to the next node.

Time Complexity:
• Deleting a node at a specific position : O(n), where n is the number of nodes in the linked list

Space Complexity:
• Constant space usage : O(1), since we only use a few variables regardless of the size of the linked list
*/  

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class DeleteAtPos {
    public static Node deleteAtPosition(Node head, int index) {
        Node current = head;
        Node previous = null;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                if (previous == null) {
                    // Deleting the head node
                    head = current.next;
                } else {
                    // Bypassing the current node
                    previous.next = current.next;
                }
                return head; // Return the modified head
            }
            previous = current;
            current = current.next;
            currentIndex++;
        }
        return head; // Return the unmodified head if index is out of bounds
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);

        int indexToDelete = 2;

        // Deleting the node at the specified index
        head = deleteAtPosition(head, indexToDelete);

        // Displaying the linked list after deletion
        System.out.print("Linked List after deleting node at index " + indexToDelete + ": ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}