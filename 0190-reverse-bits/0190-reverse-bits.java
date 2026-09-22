class Solution {
    public int reverseBits(int n) {
        
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            
            // n ki last bit nikalo
            int bit = n & 1;

            // ans ko left shift karo
            ans = (ans << 1) | bit;

            // n ko right shift karo
            n = n >>> 1;
        }

        return ans;
    }
}