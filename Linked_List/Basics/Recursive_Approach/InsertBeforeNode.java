class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertBeforeNode {
    public static Node insertBeforeNode(Node head, int data, Node target) {
        // If the target node is null, we cannot insert before it
        if (target == null) {
            return head;
        }
        
        // If the target node is the head, we need to insert the new node before it
        if (target == head) {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }

        // Traverse the list to find the node before the target node
        Node current = head;
        while (current != null && current.next != target) {
            current = current.next;
        }

        // If we reached the end of the list without finding the target, return the original head
        if (current == null) {
            return head;
        }

        // Insert the new node before the target node when current is the node before target
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node target = head.next;

        head = insertBeforeNode(head, 4, target);

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}