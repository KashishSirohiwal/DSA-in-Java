package Linked_List.Basics;

/*
Objective:
Remove the first occurrence of a target value from a linked list.

Key Steps:
• Traverse the linked list while keeping track of the current node and its previous node.
• If the data of the current node matches the target, update the previous node's next pointer to skip the current node, effectively removing it from the list.
• Empty linked list or target not found: If the linked list is empty or the target value is not found, no changes are made to the linked list.

Time Complexity:
• Removing the first occurrence : O(n), where n is the number of nodes in the linked list

Space Complexity:
• Constant space usage : O(1), since we only use a few variables regardless of the size of the linked list
*/

/* 
Your method should handle
1. Empty list : this is handled at the start of the method by checking if the head is null.
2. Target not present : if the target value is not found in the linked list, the method will simply return without making any changes to the list.
3. Target at head : this is handled by checking if the head node itself holds the target value. If it does, we update the head to point to the next node.
4. Target at tail : this is handled by checking if the current node is the last node in the list.
5. Only one Node : this is handled by checking if the head node itself holds the target value.
6. Multiple occurrences : this is handled by traversing the list and removing the first occurrence of the target value.
7. Target occurring consecutively : this is handled by traversing the list and removing all consecutive occurrences of the target value.
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class RemoveFirstOccurrence {
    public static Node removeFirstOccurrence(Node head, int target) {
        Node previous = null;
        Node current = head;

        while(current != null) {
            if(current.data == target) {
                if(previous == null) {
                    // Target is at the head
                    head = current.next;
                } else {
                    // Target is in the middle or at the end
                    previous.next = current.next;
                }
                return head; // Return the modified head
            }
            previous = current;
            current = current.next;
        }
        return head; // Return the unmodified head if target not found
    }

    public static void main(String[] args) {
        // Creating a linked list with 5 nodes
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(20);

        // Removing the first occurrence of the target value from the linked list
        int target = 10;
        head = removeFirstOccurrence(head, target);

        // Printing the modified linked list
        Node current = head;
        System.out.print("Modified linked list after removing first occurrence of " + target + ": ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next; 
        }
        System.out.println();
    }
}