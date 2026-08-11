package Linked_List.Basics;

/*
Objective:
Remove the last occurrence of a target value from a linked list.

Key Steps:
• Use lastMatch to keep track of the last node that matches the target value and lastPrev to keep track of the previous node of lastMatch.
• The need of lastPrev is that current can't be used to remove lastMatch because current will be null when the last occurrence is found.
• If lastMatch is found, update the next pointer of lastPrev to skip lastMatch, effectively removing it from the list for middle or end occurrences.
• If lastMatch is the head node, update the head to point to the next node.

Time Complexity:
• Removing the last occurrence : O(n), where n is the number of nodes in the linked list

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

public class RemoveLastOccurrence {
    public static Node removeLastOccurrence(Node head, int target) {
        Node current = head;
        Node prev = null;

        Node lastMatch = null;
        Node lastPrev = null;

        while (current != null) {
            if (current.data == target) {
                lastMatch = current;
                lastPrev = prev;
            }
            prev = current;
            current = current.next;
        }

        if (lastMatch != null) {
            if (lastPrev == null) {
                // The last occurrence is the head node
                head = head.next;
            } else {
                // Bypass the last occurrence node
                lastPrev.next = lastMatch.next;
            }
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

        // Removing the last occurrence of the target value
        head = removeLastOccurrence(head, target);

        // Displaying the linked list after removal
        System.out.print("Linked List after removing last occurrence of " + target + ": ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}