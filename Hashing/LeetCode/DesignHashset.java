package Hashing.LeetCode;
    
/*
Problem: Design HashSet (LeetCode 705)

Idea:
- Implement a basic HashSet without using built-in hash set libraries.
- Since constraints guarantee keys are in range [0, 10^6], 
  we can directly use a boolean array of size 1,000,001.
- Each index represents whether that key exists in the set.

Operations:
- add(key): mark set[key] = true
- remove(key): mark set[key] = false
- contains(key): return set[key]

Time Complexity: O(1) for all operations
Space Complexity: O(N) where N = 10^6
*/

class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001]; // keys range from 0 to 1e6
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();

        // Add keys
        obj.add(5);
        obj.add(100);
        obj.add(999999);

        // Check contains
        System.out.println("Contains 5? " + obj.contains(5));         // true
        System.out.println("Contains 100? " + obj.contains(100));     // true
        System.out.println("Contains 50? " + obj.contains(50));       // false

        // Remove a key
        obj.remove(5);
        System.out.println("Contains 5 after removal? " + obj.contains(5)); // false
    }
}