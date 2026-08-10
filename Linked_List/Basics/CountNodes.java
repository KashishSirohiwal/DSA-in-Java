package Linked_List.Basics;

/*
Objective:
Count the number of nodes in a linked list.

At every iteration:

• current identifies the current Node.
• count++ counts that Node.
• current = current.next advances to the successor.
• When current becomes null, every Node has been visited and the loop terminates.
• count is returned.

Time Complexity:
• Counting nodes : O(n), where n is the number of nodes in the linked list

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

public class CountNodes {
    public static int countNodes(Node head) {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next; // Move to the next node
        }

        return count;
    }

    public static void main(String[] args) {
        // Creating a linked list with 3 nodes
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);

        // Counting the number of nodes in the linked list
        int count = countNodes(head);
        System.out.println("Number of nodes in the linked list: " + count);
    }
}