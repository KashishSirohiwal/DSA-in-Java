package Linked_List.Basics;

/*
- Linked List is a linear data structure where each element (node) contains a reference (link) to
the next node in the sequence. It consists of nodes, where each node contains data and a pointer 
to the next node. The last node points to null, indicating the end of the list.

- Unlike arrays, the nodes in a linked list are not stored in contiguous memory locations. This allows
for efficient insertion and deletion of elements, as it does not require shifting elements like in arrays.

- Linked list is dynamic in nature, meaning it can grow or shrink in size during runtime. It is particularly
useful when the number of elements is unknown or changes frequently.

- There are different types of linked lists:
  1. Singly Linked List: Each node points to the next node, and the last node points to null.
  2. Doubly Linked List: Each node has two pointers, one pointing to the next node and another pointing
     to the previous node, allowing traversal in both directions.
  3. Circular Linked List: The last node points back to the first node, forming a circular structure.
*/

/*
Why Linked List exist?
- Problem in arrays arises from maintaining the contiguous positional organization of elements. In arrays, 
when an element is inserted or deleted, it may require shifting elements to maintain the order, which can be inefficient.

Linked list solves this problem by allowing dynamic memory allocation and efficient insertion and deletion of elements.
It trades direct index access and memory locality for flexibility in size and structure. 
*/

/*
Advantages of Linked List:
1. Dynamic Size: Linked lists can grow or shrink in size during runtime, making them suitable for scenarios where the
    number of elements is unknown or changes frequently.
2. Efficient Insertion and Deletion: Inserting or deleting elements in a linked list can be done in constant time O(1)
    if the reference to the node is known, as it does not require shifting elements like in arrays.
3. Memory Utilization: Linked lists can utilize memory more efficiently, as they do not require a contiguous block of memory.
4. Flexibility: Linked lists can easily accommodate different data structures and can be used to implement 
    other data structures like stacks, queues, and graphs.

Disadvantages of Linked List:
1. Memory Overhead: Each node in a linked list requires additional memory for storing the reference (pointer) to the next node
  which can lead to increased memory usage compared to arrays.
2. Sequential Access: Linked lists do not provide direct access to elements by index, requiring traversal from the head node to
  reach a specific element, resulting in O(n) time complexity for access.
3. Cache Locality: Linked lists may have poor cache performance compared to arrays, as the nodes may be scattered in memory,
  leading to more cache misses during traversal.
4. Complexity: Implementing and managing linked lists can be more complex than arrays, especially when dealing with edge cases
  like inserting or deleting nodes at the beginning or end of the list.
*/

class Node {
    int data;
    Node next;

    // Parameterized constructor to initialize the node with data and set the next pointer to null
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    System.out.println("Node created with data: " + data); // Print statement to indicate that a node has been created with the given data
}

public class IntroLinkedList {
  public static void main(String[] args) {
    Node node1 = new Node(10); // Creating the first node with data 10
    Node node2 = new Node(20); // Creating the second node with data 20
  }
}