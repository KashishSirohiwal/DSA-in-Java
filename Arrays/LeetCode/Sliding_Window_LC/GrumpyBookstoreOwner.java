package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Grumpy Bookstore Owner

 Approach:
 - Customers are always satisfied when the owner is not grumpy.
   → Add these directly to base satisfaction.

 - When the owner is grumpy, we can use the secret technique for a
   fixed window of size = minutes to convert them into satisfied customers.

 - Use sliding window to find the maximum extra customers that can
   be satisfied during the grumpy period.

 Steps:
 1. Compute base satisfaction (where grumpy[i] == 0)
 2. Compute extra satisfaction for the first window of size = minutes
 3. Slide the window and update extra satisfaction
 4. Take the maximum extra and add to base

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

class GrumpyBookstoreOwner {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;

        int base = 0;       // Always satisfied customers
        int extra = 0;      // Customers satisfied using secret technique
        int maxExtra = 0;

        // Step 1: Calculate base satisfaction
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }

        // Step 2: First window of size = minutes
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }

        maxExtra = extra;

        // Step 3: Slide the window
        for (int i = minutes; i < n; i++) {

            // Add incoming element
            if (grumpy[i] == 1) {
                extra += customers[i];
            }

            // Remove outgoing element
            if (grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        // Step 4: Total satisfied customers
        return base + maxExtra;
    }
    
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        int result = maxSatisfied(customers, grumpy, minutes);
        System.out.println("The maximum satisfied customers : " + result);
    }
}
