import java.util.Scanner;
public class CoinCombination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the number of coins (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the sum: ");
        int sum = scanner.nextInt();
        if (sum < 0) {
            System.out.println("Target sum must be a non-negative integer.");
            return;
        }
        
        int[] coins = new int[n];
        System.out.println("Enter the denominations of coins:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Create a CoinCombinationCounter object and start a thread
        Coin counter = new Coin(coins, sum);
        Thread thread = new Thread(counter);
        thread.start();

        // Wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the result
        System.out.println("combinations: " + counter.getResult());
        scanner.close();
    }
    
}