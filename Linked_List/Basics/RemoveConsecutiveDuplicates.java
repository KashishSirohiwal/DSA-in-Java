package Linked_List.Basics;

/*
Objective: Remove consecutive duplicate elements from a linked list.

Key concepts:
• prev pointer is not required, as we only need to check the current node and its next node for duplicates.
• If the current node's data is equal to the next node's data, we skip the next node by updating the current node's next pointer to point to the node after the next.
• while current is not null and current.next is not null is used to ensure we do not encounter a null pointer exception when accessing current.next.data.

Time Complexity:
• Removing consecutive duplicates : O(n), where n is the number of nodes in the linked list

Space Complexity:
• Constant space usage : O(1), since we only use a few variables regardless of the size of the linked list
*/

class Node {
    int data;
    Node next;
    
    Node(int value) {
        data = value;
    }
}

public class RemoveConsecutiveDuplicates {
    public static Node removeConsecutiveDuplicates(Node head) {
        Node current = head;

        while (current != null && current.next != null) {
            while (current.data == current.next.data) {
                current.next = current.next.next; // Skip the duplicate node
            }
            current = current.next;
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
        head = removeConsecutiveDuplicates(head);

        // Displaying the linked list after removal
        System.out.print("Linked List after removing consecutive duplicates: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}