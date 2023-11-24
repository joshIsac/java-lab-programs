import java.util.Scanner;

public class ShareTrader {
    private static int maxProfit;

    public static int findMaxProfit(int[] prices) {
        maxProfit = 0;
        calculateMaxProfit(prices, 0, 0, 0);
        return maxProfit;
    }

    private static void calculateMaxProfit(int[] prices, int day, int transactions, int currentProfit) {
        if (day == prices.length || transactions == 2) {
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            return;
        }

        calculateMaxProfit(prices, day + 1, transactions, currentProfit);

        for (int sellDay = day + 1; sellDay < prices.length; sellDay++) {
            if (prices[sellDay] > prices[day]) {
                int profit = prices[sellDay] - prices[day];
                calculateMaxProfit(prices, sellDay + 1, transactions + 1, currentProfit + profit);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stock prices: ");
        int n = scanner.nextInt();

        int[] stockPrices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            stockPrices[i] = scanner.nextInt();
        }

        int result = findMaxProfit(stockPrices);
        System.out.println("Maximum Profit: " + result);

        // Display transactions
        System.out.println("Trader earns " + maxProfit + " as sum of:");
        findAndDisplayTransactions(stockPrices, result);

        scanner.close();
    }

    private static void findAndDisplayTransactions(int[] prices, int totalProfit) {
        int currentProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (currentProfit == totalProfit) {
                break;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i] && (prices[j] - prices[i] + currentProfit) == totalProfit) {
                    System.out.println("Buy at " + prices[i] + ", sell at " + prices[j]);
                    currentProfit += prices[j] - prices[i];
                    break;
                }
            }
        }
    }
}
