package Linked_List.Basics;

class Node {
    int data;
    Node next;
    
    Node(int value) {
        data = value;
    }
}

public class RemoveDuplicateGroup {
    public static Node removeDuplicates(Node head) {
        Node prev = null;
        Node current = head;
        
        while (current != null) {
            // Check whether current belongs to a duplicate group
            if (current.next != null && current.data == current.next.data) {
                // Move current through the entire duplicate group
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }

                // Move to the first Node after the duplicate group
                current = current.next;
                
                // Connect the previous retained Node to current
                if (prev == null) {
                    // Duplicate group started at the head
                    head = current;
                } else {
                    // Skip the entire duplicate group
                    prev.next = current;
                }
            } else {
                // Current Node is unique, so retain it
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(10);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(15);
        head.next.next.next.next.next = new Node(20);

        // Removing consecutive duplicates
        head = removeDuplicates(head);

        // Displaying the linked list after removal
        System.out.print("Linked List after removing duplicates group: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}