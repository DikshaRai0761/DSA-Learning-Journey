class Solution {

    public int minKBitFlips(int[] nums, int k) {

        int n = nums.length;

        int[] isFlipped = new int[n];

        int flip = 0;

        int ans = 0;

        for(int i=0;i<n;i++){

            if(i>=k){
                flip -= isFlipped[i-k];
            }

            if(nums[i] == (flip % 2)){

                if(i+k>n)
                    return -1;

                ans++;

                flip++;

                isFlipped[i]=1;
            }
        }

        return ans;
    }
}