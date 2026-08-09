package Linked_List.Basics;
 
/*
Objective:
Learn how to insert elements at the beginning of a linked list.

Key Concepts:
• A linked list can be constructed dynamically by inserting elements at the beginning.
• newNode.next = head; is essential to connect the new node to the existing list.
• head = newNode; updates the head pointer to the new node.
• The order matters otherwise the old list would disconnect from the new node.
• We must preserve the old head before overwiting it with the new node.

Time Complexity:
• Insertion at the beginning : O(1), since we only update the head pointer

Space Complexity:
• One Node Object per element in the list : O(n)
*/

class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

class LinkedList {
    Node head;
    Node tail;
    
    void insertAtB(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode; // If the list is empty, set head to the new node
            tail = newNode; // Also set tail to the new node
        } else {
            newNode.next = head; // Connect the new node to the current head
            head = newNode; // Update the head to the new node
        }
    }
}

public class InsertAtBeginning {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtB(30);
        list.insertAtB(20);
        list.insertAtB(10);
        list.insertAtB(5);

        // Displaying the linked list
        Node curr = list.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}