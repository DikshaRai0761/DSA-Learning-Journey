class Solution {
    public int superPow(int a, int[] b) {
        int mod = 1337;
        a = a % mod;

        int ans = 1;

        for (int digit : b) {
            ans = (pow(ans, 10) * pow(a, digit)) % mod;
        }

        return ans;
    }

    private int pow(int a, int b) {
        int result = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % 1337;
            }

            a = (a * a) % 1337;
            b = b / 2;
        }

        return result;
    }
}