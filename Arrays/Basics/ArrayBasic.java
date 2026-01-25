package Arrays.Basics;

/*
An array is a linear data structure that stores multiple 
elements of the same data type in contiguous memory locations, 
where each element is accessed using an index.
*/

public class ArrayBasic {
    public static void main(String[] args) {
        // arr is a refernce variable and reference variable lives in stack
        // Actual array object lives in heap

        int[] arr; // Declaration
        arr = new int[5]; // Memory Allocation
        System.out.println(arr[0]); // Before explicit initialization, default values are set to zero by JVM

        arr[0] = 2; // Initilization : value assigned
        System.out.println(arr[0]); // After initialization 

        int[] arr1 = {10,20,30,40}; // Declaration + Initialization
        System.out.println(arr1); // Address of array object in heap
        
        /*
        Arrays size being fixed?    
        When we write :
        new int[5]; 

        - JVM reserves continous memory : 5 * size of int(4 byte)
        - Allocates memory at once
        - Because memory is allocated in one block:
           - JVM cannot expand or shrink it later
           - That’s why arrays are fixed size
        */
    }
}
