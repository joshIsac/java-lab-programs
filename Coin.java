class Coin implements Runnable {
    private int[] coins;
    private int sum;
    private int result;

    public Coin(int[] coins, int sum) {
        this.coins = coins;
        this.sum = sum;
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        // Call the helper function to calculate combinations
        result =combinations(coins, sum);
    }

    private int combinations(int[] coins, int sum) {
      int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return n;
    }}
