package Linked_List.Basics;

/*
Objective:
Calculate the sum of all even-valued nodes in a linked list.

At every iteration:
• current identifies the current Node.
• If the data of the current node is even, add it to the sum.
• Move to the next node.

Time Complexity:
• Calculating the sum of even nodes : O(n), where n is the number of nodes in the linked list

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

public class SumEvenNodes {
    public static int sumEvenNodes(Node head) {
        int sum = 0;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                sum += current.data; // Add even node's data to sum
            }
            current = current.next; // Move to the next node
        }

        return sum; // Return the total sum of even nodes
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);

        // Calculating the sum of even nodes in the linked list
        int sumOfEvenNodes = sumEvenNodes(head);

        System.out.println("The sum of even nodes in the linked list is: " + sumOfEvenNodes);
    }
}