class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // First window check
        if (sum >= k * threshold) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            sum = sum + arr[i] - arr[i - k];

            if (sum >= k * threshold) {
                count++;
            }
        }

        return count;
    }
}