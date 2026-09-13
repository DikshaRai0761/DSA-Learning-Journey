class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            
            int index = i % n;
            
            // Chhote elements remove karo
            while (!st.isEmpty() && st.peek() <= nums[index]) {
                st.pop();
            }
            
            // Greater element
            if (i < n) {
                if (st.isEmpty()) {
                    ans[index] = -1;
                } else {
                    ans[index] = st.peek();
                }
            }
            
            // Current element stack me daalo
            st.push(nums[index]);
        }
        
        return ans;
    }
}