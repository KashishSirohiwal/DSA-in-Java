package Linked_List.Basics;

/*
Objective:
Check if a linked list contains adjacent duplicate values.

At every iteration:
• current identifies the current Node.
• If the data of the current node matches the data of the next node, return true.
• Otherwise, move to the next node.
• If the loop terminates without finding adjacent duplicates, return false.

Time Complexity:
• Checking for adjacent duplicates : O(n), where n is the number of nodes in the linked list

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

public class HasAdjacentDuplicates {
    public static boolean hasAdjacentDuplicates(Node head) {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                return true; // Found adjacent duplicates
            }
            current = current.next; // Move to the next node
        }

        return false; // No adjacent duplicates found
    }

    public static void main(String[] args) {
        // Creating a linked list with adjacent duplicates
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(10); // Adjacent duplicate
        head.next.next.next = new Node(15);

        // Checking for adjacent duplicates in the linked list
        boolean hasDuplicates = hasAdjacentDuplicates(head);

        if (hasDuplicates) {
            System.out.println("The linked list has adjacent duplicates.");
        } else {
            System.out.println("The linked list does not have adjacent duplicates.");
        }
    }
}