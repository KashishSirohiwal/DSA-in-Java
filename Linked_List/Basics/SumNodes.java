package Linked_List.Basics;

/*
Objective:
Calculate the sum of all nodes in a linked list.

At every iteration:
• current identifies the current Node.
• sum += current.data adds the data of the current node to the sum.
• current = current.next advances to the successor.
• When current becomes null, every Node has been visited and the loop terminates.

Time Complexity:
• Summing nodes : O(n), where n is the number of nodes in the linked list

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

public class SumNodes {
    public static int sumNodes(Node head) {
        int sum = 0;
        Node current = head;

        while (current != null) {
            sum += current.data; // Add the data of the current node to the sum
            current = current.next; // Move to the next node
        }

        return sum;
    }

    public static void main(String[] args) {
        // Creating a linked list with 3 nodes
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        
        // Calculating the sum of all nodes in the linked list
        int sum = sumNodes(head);
        System.out.println("Sum of all nodes in the linked list: " + sum);
    }
}