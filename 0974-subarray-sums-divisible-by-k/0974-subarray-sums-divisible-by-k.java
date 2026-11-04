class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int[] f = new int[k];

        f[0] = 1;

        int sum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            res += f[rem];

            f[rem]++;
        }

        return res;
    }
}