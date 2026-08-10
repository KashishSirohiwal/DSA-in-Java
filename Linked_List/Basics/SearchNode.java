package Linked_List.Basics;

/*
Objective:
Search for a specific target in a linked list.

At every iteration:

• current identifies the current Node.
• If the data of the current node matches the target, return true.
• Otherwise, move to the next node.
• If the loop terminates without finding the target, return false.

Time Complexity:
• Searching for a target : O(n), where n is the number of nodes in the linked list and O(1) if head is the target

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

public class SearchNode {
    public static boolean searchNode(Node head, int target) {
        Node current = head;

        while (current != null) {
            if (current.data == target) {
                return true; // Target found
            }
            current = current.next; // Move to the next node
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        // Creating a linked list with 3 nodes
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);

        // Searching for a specific value in the linked list
        int searchValue = 10;
        boolean found = searchNode(head, searchValue);

        if (found) {
            System.out.println("Value " + searchValue + " found in the linked list.");
        } else {
            System.out.println("Value " + searchValue + " not found in the linked list.");
        }
    }
}