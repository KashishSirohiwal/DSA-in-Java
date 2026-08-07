package Linked_List.Basics;

/*
Objective:
Learn how to manually create Node objects and establish connections using reference assignments.

Key Concepts:
• Each 'new Node()' creates a separate object in Heap memory.
• A Linked List is formed by connecting nodes through the 'next' reference.
• 'next' stores a reference, not the actual object.
• The last node always stores null in its next field.
• No new object is created while connecting nodes.

Time Complexity:
• Node Creation : O(1)
• Connecting Nodes : O(1)

Space Complexity:
• One Node Object : O(1)
*/

public class ManualNodeConstruction {
    public static void main(String[] args) {

        // Creating independent nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Connecting the nodes manually
        first.next = second;
        second.next = third;

        // Displaying the connections
        System.out.println("First Node : " + first.data);
        System.out.println("Second Node : " + first.next.data);
        System.out.println("Third Node : " + first.next.next.data);

        // Checking the end of the linked list
        System.out.println("Is third node the last node? " + (third.next == null));
    }
}