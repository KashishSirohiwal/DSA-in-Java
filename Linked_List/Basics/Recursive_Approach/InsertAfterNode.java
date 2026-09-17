/*
Steps:
1. Create a new node with the given data.
2. If the target node is null, return the original head.
3. Set the new node's next to the target node's next.
4. Set the target node's next to the new node.

Time Complexity: O(1), as we are directly inserting the new node after the target node without traversing the list.
Space Complexity: O(1), as we are using a constant amount of extra space for the
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAfterNode {
    public static Node insertAfterNode(Node head, int data, Node target) {

        if (target == null) {
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = target.next;
        target.next = newNode;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node target = head.next;
        head = insertAfterNode(head, 4, target);

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}