class Solution {
    public int maximumScore(int[] nums, int k) {

        int n = nums.length;

        int left = k;
        int right = k;

        int min = nums[k];

        int maxScore = min;

        while (left > 0 || right < n - 1) {

            if (left == 0) {
                right++;
            }
            else if (right == n - 1) {
                left--;
            }
            else if (nums[left - 1] > nums[right + 1]) {
                left--;
            }
            else {
                right++;
            }

            min = Math.min(min, Math.min(nums[left], nums[right]));

            int length = right - left + 1;

            int score = min * length;

            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}