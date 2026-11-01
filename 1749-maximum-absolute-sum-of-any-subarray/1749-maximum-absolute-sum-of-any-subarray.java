class Solution {
    public int maxAbsoluteSum(int[] nums) {
     int maxSum=0;
     int sum=0;
     for(int i=0; i<nums.length; i++){
sum+=nums[i];
if(sum<0){
    sum=0;
}
maxSum=Math.max(maxSum,sum);
     }   
     int minSum=0;
     sum=0;
     for(int i=0; i<nums.length; i++){
        sum+=nums[i];
        if(sum>0){
            sum=0;
        }
        minSum=Math.min(minSum,sum);
     }
     return Math.max(maxSum,Math.abs(minSum));
    }
}