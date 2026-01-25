package Arrays.Basics;

/*
Traversal in an array refers to the process of 
accessing each element in the array sequentially
*/
public class ArrayTraversal {
    public static void main(String[] args) {
        System.out.println("1. for loop");
        /*
        This method is ideal when you know the number of 
        elements in the array beforehand or when you need to 
        access each element by its index */

        int[] arr = {10,20,30,40,50};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n2. while loop");
        /*
        The while loop can be useful when the number of 
        iterations isn't predetermined or when the loop may need 
        to stop based on a condition other than the array size. */

        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }

        System.out.println("\n3. enhanced for-loop");
        /*
        also known as a range-based for loop , simplifies array 
        traversal by directly accessing each element of 
        the array without needing to manually manage the index. 
        Used for read-only traversal. */

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
