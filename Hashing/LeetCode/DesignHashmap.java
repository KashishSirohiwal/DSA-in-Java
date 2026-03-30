package Hashing.LeetCode;
import java.util.Arrays;

/*
Problem: Design HashMap (LeetCode 706)

Idea:
- Implement a basic HashMap without using built-in hash map libraries.
- Since constraints guarantee keys are in range [0, 10^6],
  we can directly use an int array of size 1,000,001.
- Initialize all values to -1 (meaning "not present").
- Each index represents the key, and the stored value is the mapped value.

Operations:
- put(key, value): store value at index key
- get(key): return value at index key (or -1 if not present)
- remove(key): reset value at index key to -1

Time Complexity: O(1) for all operations
Space Complexity: O(N) where N = 10^6
*/

class MyHashMap {
    private int[] map;

    public MyHashMap() {
        map = new int[1000001]; // keys range from 0 to 1e6
        Arrays.fill(map, -1);   // initialize all values to -1
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();

        // Put some key-value pairs
        obj.put(5, 100);
        obj.put(10, 200);
        obj.put(999999, 42);

        // Get values
        System.out.println("Value at key 5: " + obj.get(5));       // 100
        System.out.println("Value at key 10: " + obj.get(10));     // 200
        System.out.println("Value at key 50: " + obj.get(50));     // -1 (not present)

        // Remove a key
        obj.remove(5);
        System.out.println("Value at key 5 after removal: " + obj.get(5)); // -1
    }
}