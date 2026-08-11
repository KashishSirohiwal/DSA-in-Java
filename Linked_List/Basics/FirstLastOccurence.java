package Linked_List.Basics;

/*
Objective:
Find the first and last occurrence of a target value in a linked list.

At every iteration:
• current identifies the current Node.
• For first occurrence, if the data of the current node matches the target, return the current index.
• For last occurrence, if the data of the current node matches the target, update the last occurrence index.

Time Complexity:
• Finding first and last occurrence : O(n), where n is the number of nodes in the linked list

Space Complexity:
• Constant space usage : O(1), since we only use a few variables regardless of the size of the linked list
*/

Node class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class FirstLastOccurence {
    public static int firstOccurrence(Node head, int target) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == target) {
                return index; // Found the first occurrence
            }
            current = current.next; // Move to the next node
            index++;
        }

        return -1; // Target not found
    }

    public static int lastOccurrence(Node head, int target) {
        Node current = head;
        int index = 0;
        int lastIndex = -1;

        while (current != null) {
            if (current.data == target) {
                lastIndex = index; // Update last occurrence index
            }
            current = current.next; // Move to the next node
            index++;
        }

        return lastIndex; // Return the last occurrence index or -1 if not found
    }

    public static void main(String[] args) {
        // Creating a linked list: 5 -> 10 -> 15 -> 10 -> 20
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(20);

        int target = 10;

        // Finding the first occurrence of the target value
        int firstIndex = firstOccurrence(head, target);
        if (firstIndex != -1) {
            System.out.println("The first occurrence of " + target + " is at index: " + firstIndex);
        } else {
            System.out.println(target + " is not found in the linked list.");
        }

        // Finding the last occurrence of the target value
        int lastIndex = lastOccurrence(head, target);
        if (lastIndex != -1) {
            System.out.println("The last occurrence of " + target + " is at index: " + lastIndex);
        } else {
            System.out.println(target + " is not found in the linked list.");
        }
    }
}