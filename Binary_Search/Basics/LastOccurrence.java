package Binary_Search.Basics;

public class LastOccurrence {
    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } 
            
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 4, 10};
        int target = 2;
        System.out.println("The last occurrence of " + target + " : " + lastOccurrence(arr, target)); 
    }
}