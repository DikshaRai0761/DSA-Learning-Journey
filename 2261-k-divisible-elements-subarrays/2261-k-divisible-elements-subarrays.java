class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int count = 0;
            StringBuilder sub = new StringBuilder();
            
            for (int j = i; j < nums.length; j++) {
                
                if (nums[j] % p == 0) {
                    count++;
                }
                
                // More than k divisible elements
                if (count > k) {
                    break;
                }
                
                sub.append(nums[j]).append(",");
                set.add(sub.toString());
            }
        }
        
        return set.size();
    }
}