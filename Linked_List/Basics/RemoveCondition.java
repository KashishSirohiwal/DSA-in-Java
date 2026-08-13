package Linked_List.Basics;

/*
Objective: Remove all nodes from a linked list that satisfy a given condition

Key Steps:
• Use two pointers, current and prev, to traverse the linked list.
• If the current node's data satisfies the condition (e.g., is even), bypass the current node by updating the next pointer of prev to skip current.
• If the current node's data does not satisfy the condition, move prev to current.
• If the condition is satisfied at the head node, update the head to point to the next node.

Time Complexity:
• Removing nodes based on a condition : O(n), where n is the number of nodes in the linked list

Space Complexity:
• Constant space usage : O(1), since we only use a few variables regardless of the size of the linked list
*/ 

public class RemoveCondition {
    public static Node removeCondition(Node head, int target) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data % 2 == 0) { // Condition: Remove even numbers
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
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(25);

        // Removing all even numbers from the linked list
        head = removeCondition(head, 0); // The target parameter is not used in this case

        // Displaying the linked list after removal
        System.out.print("Linked List after removing even numbers: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}