class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // New element window me add hua
            if (nums[right] == 0) {
                zeros++;
            }

            // Agar zeros k se zyada ho gaye
            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            // Current valid window ki length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}