class Solution {
    public double new21Game(int n, int k, int maxPts) {

        // Alice stops drawing when score reaches k.
        // If n >= k + maxPts - 1, she can never exceed n.
        if (k == 0 || n >= k + maxPts - 1) {
            return 1.0;
        }

        double[] dp = new double[n + 1];

        dp[0] = 1.0;

        double windowSum = 1.0;
        double ans = 0.0;

        for (int i = 1; i <= n; i++) {

            dp[i] = windowSum / maxPts;

            // If i is a valid stopping score
            if (i < k) {
                windowSum += dp[i];
            } else {
                ans += dp[i];
            }

            // Remove the score which is now outside the window
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return ans;
    }
}