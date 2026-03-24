package Arrays.LeetCode.Greedy;
import java.util.Scanner;

/*
Problem: Best Time to Buy and Sell Stock II (LeetCode 122)

Idea:
- You can make unlimited transactions (buy -> sell -> buy -> sell).
- The maximum profit is obtained by summing all positive differences between consecutive days.

Technique Used:
- Greedy approach.
- Whenever prices[i] > prices[i-1], add (prices[i] - prices[i-1]) to profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class BestTimeToBuySellStockII {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter stock prices: ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);
        System.out.println("Maximum Profit with unlimited transactions: " + result);

        sc.close();
    }
}
