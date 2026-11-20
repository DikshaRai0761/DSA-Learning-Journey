class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit=0;
      int minprice=prices[0];
      for(int i=1; i<prices.length; i++){
        if(prices[i]<minprice){
            minprice=prices[i];
        }else{
            int profit=prices[i]-minprice;
            maxProfit=Math.max(maxProfit, profit);
        }
      }
      return maxProfit;  
    }
}