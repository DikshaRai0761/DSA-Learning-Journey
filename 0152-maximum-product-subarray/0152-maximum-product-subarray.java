class Solution {
    public int maxProduct(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            if (curr < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            maxEnding = Math.max(curr, maxEnding * curr);
            minEnding = Math.min(curr, minEnding * curr);

            res = Math.max(res, maxEnding);
        }

        return res;
    }
}