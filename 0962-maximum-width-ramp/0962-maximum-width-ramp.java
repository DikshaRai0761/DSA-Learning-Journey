class Solution {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        // Step 1: decreasing values ke indices store karo
        for (int i = 0; i < n; i++) {

            if (top == -1 || nums[i] < nums[stack[top]]) {
                stack[++top] = i;
            }
        }

        int maxWidth = 0;

        // Step 2: right se traverse karo
        for (int j = n - 1; j >= 0; j--) {

            while (top >= 0 && nums[stack[top]] <= nums[j]) {

                int i = stack[top--];

                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }
}