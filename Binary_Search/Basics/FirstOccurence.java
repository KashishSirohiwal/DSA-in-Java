package Binary_Search.Basics;

public class FirstOccurence {
    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
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
        System.out.println("The first occurrence of " + target + " : " + firstOccurrence(arr, target)); 
    }
}