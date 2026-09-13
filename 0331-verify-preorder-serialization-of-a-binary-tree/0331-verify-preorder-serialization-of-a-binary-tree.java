class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        
        int slots = 1;  // root ke liye 1 slot

        for (String node : nodes) {
            
            // Current node ko ek slot chahiye
            slots--;
            
            // Agar slot hi nahi hai, tree invalid
            if (slots < 0) {
                return false;
            }
            
            // Normal node 2 children ke liye 2 slots banata hai
            if (!node.equals("#")) {
                slots += 2;
            }
        }
        
        // End me exactly 0 slots hone chahiye
        return slots == 0;
    }
}