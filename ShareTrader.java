import java.util.Scanner;

public class ShareTrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stock prices: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        calculateAndPrintMaxProfit(prices);

        scanner.close();
    }

    private static void calculateAndPrintMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            System.out.println("Not enough prices to trade.");
            return;
        }

        int buy1 = Integer.MAX_VALUE, sell1 = 0;
        int buy2 = Integer.MAX_VALUE, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.min(buy2, price - sell1);
            sell2 = Math.max(sell2, price - buy2);
        }

        int totalProfit = sell1 + sell2;

        System.out.println("Output: " + totalProfit);
        System.out.println("Trader earns " + totalProfit + " as sum of " + sell1 + " and " + sell2);
        System.out.println("Buy at " + prices[0] + ", sell at " + (prices[0] + sell1) + ",");
        System.out.println("Buy at " + (prices[0] + sell1 - buy2) + " and sell at " + (prices[0] + sell1 + sell2));
    }
}
