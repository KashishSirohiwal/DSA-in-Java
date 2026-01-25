package Arrays.Basics;

public class ArrayIndexing {
    public static void main(String[] args) {
        /* 
        Indexing in arrays 
        - Arrays are zero-indexed as first element is at : 0th index
        - Last element is at : (length - 1) index
        */
       int[] arr = {23,54,78,12,39};
       System.out.println(arr[0]); // first element
       System.out.println(arr[arr.length - 1]); // last element

       /* 
       When we try to access arr[3] :
       - JVM internally performs calculations to find exact address in heap
       - address = base_address + (index * size_of_datatype)
       - for arr[3] the address = base + (3 * 4)
       */

       int[] arr1 = new int[5];
       System.out.println(arr1[2]); // Accessible
       // System.out.println(arr1[6]) : ArrayIndexOutOfBoundsException as index is out of bound
       /*
       - JVM performs runtime bounds checking
       - Prevents memory corruption
       - Ensures security 
       */
    }
}
