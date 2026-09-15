/*
Problem: 817. Linked List Components

Method: HashSet to store the values of nums + basic linked list traversal

Steps:
1. Create a HashSet to store the values from the nums array for O(1) lookups.
2. Initialize a counter to keep track of the number of connected components.
3. Traverse the linked list using a pointer (current).
4. For each node, check if its value is in the HashSet and if it is the last node of a component (i.e., the next node is either null or not in the HashSet).
5. If both conditions are met, increment the counter.
6. Move to the next node in the linked list and repeat the process until the end of the list is reached.

Time Complexity: O(n + m) where n is the number of nodes in the linked list and m is the number of elements in nums.
Space Complexity: O(m) where m is the number of elements in nums (for the HashSet).
*/

class Solution { 
    public int numComponents(ListNode head, int[] nums) { 
        Set<Integer> set = new HashSet<>(); 
 
        for (int n : nums) set.add(n); 
 
        int count = 0; 
        ListNode current = head; 
 
        while (current != null) { 
            if (set.contains(current.val) &&  
                (current.next == null || !set.contains(current.next.val))) { 
                count++; 
            } 
            current = current.next; 
        } 
 
        return count; 
    } 
}