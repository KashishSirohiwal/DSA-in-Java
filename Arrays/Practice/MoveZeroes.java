package Arrays.Practice;

public class MoveZeroes {
    public static int[] moveZero(int[] arr) {
        // This approach moves zeroes but does NOT preserve order
        /* 
        int left = 0;
        int right = 0;
        while (left < right) {
            if (arr[left] != 0) {
                left++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            }
        }
        return arr;
        */

        // Pointer to place the next non-zero element
        int index = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // If current element is non-zero
            if (arr[i] != 0) {

                // Place it at the correct position
                arr[index] = arr[i];
                index++;
            }
        }
        
        // Fill remaining positions with zeroes
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }

        return arr;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,3,0,4,5};
        System.out.print("Original Array : ");
        printArray(arr);
        int[] result = moveZero(arr);
        System.out.print("\nMove Zeros Array : ");
        printArray(result);
    }
}
