class Solution {
    public int maxResult(int[] nums, int k) {

        int n = nums.length;

        int[] dp = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();

        dp[0] = nums[0];
        dq.addLast(0);

        for (int i = 1; i < n; i++) {

            // Window se bahar wale index ko remove karo
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // Front par maximum dp value hai
            dp[i] = nums[i] + dp[dq.peekFirst()];

            // Smaller dp values ko remove karo
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        return dp[n - 1];
    }
}