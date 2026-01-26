package Arrays.Practice;

public class ReverseArray {
    public static int[] reverseArray(int[] arr) {
        int left = 0; // Pointer at beginning
        int right = arr.length - 1; // Pointer at beginning
        
        // Continue until pointers cross each other
        while (left < right) {

            // Swap elements at start and end
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers inward
            left++;
            right--;
        }
        return arr;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.print("Original Array : ");
        printArray(arr);
        int[] result = reverseArray(arr);
        System.out.print("\nReversed Array : ");
        printArray(result);
    }
}
