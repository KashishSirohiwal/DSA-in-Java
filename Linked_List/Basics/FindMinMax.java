package Linked_List.Basics;

/*
Objective:
Find the minimum and maximum values in a linked list.

Key Concepts:
• head = null can't have min and max values, so we handle that case first.
• We initialize min and max with the value of the head node to tackle the case where the list has only one node and negative values.
• We traverse the linked list using a current pointer, comparing each node's data with the current min and max values.

Time Complexity:
• Finding minimum and maximum values : O(n), where n is the number of nodes in the linked list

Space Complexity:
• Constant space usage : O(1), since we only use a few variables regardless of the size of the linked list
*/

public class FindMinMax {
    public static int findMin(Node head) {
        if (head == null) {
            System.out.println("The linked list is empty. No minimum value.");
            return Integer.MAX_VALUE; // Return a large value to indicate an error
        }

        int min = head.data;
        Node current = head;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

        return min;
    }

    public static int findMax(Node head) {
        if (head == null) {
            System.out.println("The linked list is empty. No maximum value.");
            return Integer.MIN_VALUE; // Return a small value to indicate an error
        }

        int max = head.data;
        Node current = head;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    public static void findMinMax(Node head) {
        int min = findMin(head);
        int max = findMax(head);

        System.out.println("Minimum value in the linked list: " + min);
        System.out.println("Maximum value in the linked list: " + max);
    }
}