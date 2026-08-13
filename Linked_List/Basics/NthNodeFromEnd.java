package Linked_List.Basics;

/*
Objective: Find the nth node from the end of a linked list.

Key Steps:
• Use two pointers, slow and fast, initialized to the head of the list.
• Fixed gap idea is used to maintain a gap of n nodes between the slow and fast pointers.
• Move the fast pointer n steps ahead. If the fast pointer reaches null before completing n steps, 
  it means n is greater than the length of the linked list, and we return null.
• Move both pointers one step at a time until the fast pointer reaches the end of the list.
• At this point, the slow pointer will be at the nth node from the end of the list.

Time Complexity:
• Finding the nth node from the end : O(n), where n is the number of nodes in the linked list

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

public class NthNodeFromEnd {
    public static Node findNthNodeFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;

        for(int i = 0; i < n; i++) {
            if (fast == null) {
                return null; // n is greater than the length of the linked list
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // slow pointer will be at the nth node from the end
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(25);

        int n = 2;

        // Finding the nth node from the end
        Node nthNodeFromEnd = findNthNodeFromEnd(head, n);

        // Displaying the nth node's data
        if (nthNodeFromEnd != null) {
            System.out.println(n + "th node from the end data: " + nthNodeFromEnd.data);
        } else {
            System.out.println("The linked list has fewer than " + n + " nodes.");
        }
    }
}