package Linked_List.Basics;

/*
Objective:
Remove all occurrences of a target value from a linked list.

Key Steps:
• Use two pointers, current and prev, to traverse the linked list.
• If the current node's data matches the target value, bypass the current node by updating the next pointer of prev to skip current.
• If the current node's data does not match the target value, move prev to current.
• After deleting current, previous remains the predecessor from which we continue examining Nodes.
• If the target value is found at the head node, update the head to point to the next node.

Time Complexity:
• Removing all occurrences : O(n), where n is the number of nodes in the linked list

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

public class RemoveAllOccurrence {
    public static Node removeAllOccurrences(Node head, int target) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == target) {
                if (prev == null) {
                    // The target is at the head node
                    head = current.next;
                    current = head; // Move current to the new head
                } else {
                    // Bypass the current node
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(20);

        int target = 10;

        // Removing all occurrences of the target value
        head = removeAllOccurrences(head, target);

        // Displaying the linked list after removal
        System.out.print("Linked List after removing all occurrences of " + target + ": ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}