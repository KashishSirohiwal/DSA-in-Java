package Arrays.LeetCode;
import java.util.Scanner;
/*
Problem: Best Time to Buy and Sell Stock

Idea:
- We want to find the maximum profit from a single buy and sell operation.
- We can keep track of the minimum price seen so far and calculate the potential profit at each step.
- The maximum profit is the maximum of all potential profits calculated.

Technique Used:
- Single Pass with Tracking Minimum Price
- Iterate through the price array once.
- Update the minimum price and calculate potential profit at each step.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Important Note:
- min represents the minimum price encountered so far. This guarantees buy happens before sell.
- min is updated only when a lower price is found, ensuring we always consider the lowest buying price.
*/

class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0; int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (prices[i] < min) min = prices[i];

            profit = price - min;
            max = Math.max(profit, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter element values : ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);

        sc.close();
    }
}