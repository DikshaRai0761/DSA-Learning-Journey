class Solution {
    public int minimumCoins(int[] prices) {

        int n = prices.length;

        int[] dp = new int[n + 1];

        // Large value
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            // Buy fruit i
            int cost = dp[i] + prices[i];

            // We can cover next i+1 fruits
            for (int j = i + 1; j <= Math.min(n, 2 * i + 2); j++) {
                dp[j] = Math.min(dp[j], cost);
            }
        }

        return dp[n];
    }
}