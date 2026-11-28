class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxF = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int[] it : items) {
            maxF = Math.max(maxF, it[0]);
            minPrice = Math.min(minPrice, it[1]);
        }

        int[] freq = new int[maxF + 1];
        for (int[] it : items) freq[it[0]]++;

        // multiples[f] = items jinka factor f ka multiple hai
        int[] multiples = new int[maxF + 1];
        for (int f = 1; f <= maxF; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= maxF; m += f) {
                multiples[f] += freq[m];
            }
        }

        // price ke hisaab se sort
        int[][] sorted = items.clone();
        java.util.Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));

        long total = 0;
        long remaining = budget;

        for (int[] it : sorted) {
            int price = it[1];
            if (price >= 2L * minPrice || price > remaining) break;

            int bonus = multiples[it[0]] - 1; // khud ko hata do
            long take = Math.min(bonus, remaining / price);

            total += 2 * take;
            remaining -= take * price;
        }

        total += remaining / minPrice;
        return (int) total;
    }
}