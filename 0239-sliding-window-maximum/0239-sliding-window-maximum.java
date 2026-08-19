class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int j = 0;

        for (int i = 0; i < n; i++) {

            // 1. Window se bahar wale index ko remove karo
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Chhote elements ko remove karo
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Current index add karo
            dq.offerLast(i);

            // 4. Window complete hone ke baad answer
            if (i >= k - 1) {
                ans[j] = nums[dq.peekFirst()];
                j++;
            }
        }

        return ans;
    }
}