package Linked_List.Basics;

/*
Objective:
Learn how to insert elements at the end of a linked list.

Key Concepts:
• A linked list can be constructed dynamically by inserting elements at the end.
• The head pointer keeps track of the first node, while the tail pointer keeps track of the last node.

Time Complexity:
• Insertion at the end : O(1), since we maintain a tail pointer

Space Complexity:
• One Node Object per element in the list : O(n)
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data); // Create a new node with the given data

        if (head == null) {
            head = newNode; // If the list is empty, set head to the new node
            tail = newNode; // Also set tail to the new node
        } else {
            tail.next = newNode; // Connect the new node to the end of the list
            tail = newNode; // Update the tail to the new last node
        }
    }
}

public class InsertAtEnd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting elements at the end of the linked list
        list.insertAtEnd(5);
        list.insertAtEnd(10);
        list.insertAtEnd(15);
        list.insertAtEnd(20);
        list.insertAtEnd(25);

        // Displaying the linked list
        Node current = list.head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // Move to the next node
        }
    }
}