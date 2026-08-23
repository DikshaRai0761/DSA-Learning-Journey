class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        int n = deck.length;
        int[] ans = new int[n];

        Queue<Integer> q = new LinkedList<>();

        // Positions ko queue me daalo
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        for (int card : deck) {

            // Current position par smallest card rakho
            int pos = q.poll();
            ans[pos] = card;

            // Agar positions bachhi hain
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }

        return ans;
    }
}