package Arrays.Basics;

/*
Two Pointer Technique is a problem-solving approach where two 
indices (pointers) are used to traverse an array in a coordinated
manner to reduce time complexity and avoid unnecessary extra space. 
Key points:
 - It is a TECHNIQUE, not a data structure
 - Pointers are simply integer indices.
 - Used to optimize time complexity by avoiding nested loops.
 - Frequently reduces time from O(n^2) to O(n).
 - Often works in-place (O(1) extra space).
*/

public class TwoPointerIntro {
    public static void explainTwoPointers(int[] arr) {

        // Pointer starting from the beginning of the array
        int left = 0;

        // Pointer starting from the end of the array
        int right = arr.length - 1;

        /*
         Loop condition:
         The loop continues while left index is less than right index.
         When left >= right, all required comparisons or operations
         between elements have already been completed.
        */
        while (left < right) {

            /*
             At this point:
             - 'left' points to an element from the beginning
             - 'right' points to an element from the end

             Any comparison or operation is performed
             using arr[left] and arr[right].
            */

            // --- No problem-specific logic is written here ---
            // This class is meant only to demonstrate pointer movement.

            /*
             Pointer movement:
             After performing the required operation,
             pointers are moved toward each other.

             This reduces the search space in each iteration.
            */
            left++;
            right--;
        }

        /*
         When the loop ends:
         - All necessary element pairs have been processed
         - No extra memory was used
         - The array remains in the same memory location
        */
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        explainTwoPointers(arr);
    }
}
