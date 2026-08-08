package Linked_List.Basics;

/*
Objective:
Learn how to construct a linked list robustly using a loop and an array of values.

Key Concepts:
• A linked list can be constructed dynamically by iterating through an array of values.
• The head pointer keeps track of the first node, while the tail pointer keeps track of the last node.
• Each new node is created and connected to the list in a single pass.

Time Complexity:
• Node Creation and Connection : O(n), where n is the number of elements in the array

Space Complexity:
• One Node Object per element in the array : O(n)
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class RobustConstruction {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25}; // Sample array to create linked list from

        Node head = null; // Start with an empty list
        Node tail = null; // Tail pointer to keep track of the last node

        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // Create a new node for each element

            if (head == null) {
                head = newNode; // If the list is empty, set head to the new node
                tail = newNode; // Also set tail to the new node
            } else {
                tail.next = newNode; // Connect the new node to the end of the list
                tail = newNode; // Update the tail to the new last node
            }
        }

        // Displaying the linked list
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // Move to the next node
        }
    }
}