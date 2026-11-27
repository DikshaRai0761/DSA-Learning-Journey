class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        int minPrice = items[0][1];

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            if (price < minPrice) {
                minPrice = price;
            }
            int value = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    value++;
                }
            }

            for (int money = budget; money >= price; money--) {
                dp[money] = Math.max(dp[money], dp[money - price] + value);
            }
        }

        int answer = 0;
        for (int money = 0; money <= budget; money++) {
            int extra = (budget - money) / minPrice;
            answer = Math.max(answer, dp[money] + extra);
            }

        return answer;
    }
}