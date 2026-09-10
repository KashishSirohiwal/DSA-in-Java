class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
    }
}

public class IsPalindromeRecursive {

    private static Node left;

    // Recursive function to check if the linked list is a palindrome
    public static boolean isPalindrome(Node right) {
        // Base case: reached the end of the list
        if (right == null) {
            return true;
        }

        // Recurse to the end of the list
        boolean isPal = isPalindrome(right.next);
        if (!isPal) {
            return false;
        }

        // Check if the current left and right nodes are equal
        if (left.data != right.data) {
            return false;
        }
        left = left.next; // Move left pointer forward
        return true;

        /*If we want to store result in a variable instead of returning directly, we can do the following:
        boolean result = left.data == right.data;
        left = left.next; // Move left pointer forward
        return result;
        */
    }

    public static void main(String[] args) {
        // Example: 1 → 2 → 3 → 2 → 1 → null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        left = head; // Initialize left pointer
        boolean result = isPalindrome(head);

        System.out.println("Is palindrome: " + result); // Output: Is palindrome: true
    }
}