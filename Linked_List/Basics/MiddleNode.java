package Linked_List.Basics;

/*
Objective: Find the middle node of a linked list.

Key Steps:
• Slow and fast pointer technique is used to find the middle node where the slow pointer moves one step at a time and the fast pointer moves two steps at a time.
• When the fast pointer reaches the end of the list, the slow pointer will be at the middle node. 

Time Complexity:
• Finding the middle node : O(n), where n is the number of nodes in the linked list

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

public class MiddleNode {
    public static Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        // Node fast = head.next; // For first middle node in case of even number of nodes

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2
        }

        return slow; // Slow pointer will be at the middle node
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(25);

        // Finding the middle node
        Node middleNode = findMiddleNode(head);

        // Displaying the middle node's data
        if (middleNode != null) {
            System.out.println("Middle node data: " + middleNode.data);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}