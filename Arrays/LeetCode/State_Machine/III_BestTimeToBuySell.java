package Arrays.LeetCode.State_Machine;

import java.util.Scanner;

/*
Problem: Best Time to Buy and Sell Stock III (LeetCode 123)

Idea:
- You can make at most two transactions (buy → sell → buy → sell).
- We need to maximize the total profit across these two transactions.

Technique Used:
- Dynamic Programming (State Machine).
- Maintain four states:
    * buy1  : best profit after first buy
    * sell1 : best profit after first sell
    * buy2  : best profit after second buy
    * sell2 : best profit after second sell

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Important Notes:
- buy1 starts as -prices[0] (spending money).
- sell1 starts as 0 (no profit yet).
- buy2 starts as -prices[0] (spending money again).
- sell2 starts as 0 (no profit yet).
- At each step, update states to reflect the best possible scenario.
*/

class BestTimeToBuySellStockIII {
    public static int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            buy1  = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2  = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
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
        System.out.println("Maximum Profit with at most 2 transactions: " + result);

        sc.close();
    }
}

