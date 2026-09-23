class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> ans = new ArrayList<>();
        
        for (String query : queries) {
            
            int j = 0;
            boolean match = true;
            
            for (int i = 0; i < query.length(); i++) {
                
                char ch = query.charAt(i);
                
                // Pattern character match
                if (j < pattern.length() && ch == pattern.charAt(j)) {
                    j++;
                }
                
                // Extra uppercase character not allowed
                else if (Character.isUpperCase(ch)) {
                    match = false;
                    break;
                }
            }
            
            // Pattern completely matched hona chahiye
            if (j != pattern.length()) {
                match = false;
            }
            
            ans.add(match);
        }
        
        return ans;
    }
}