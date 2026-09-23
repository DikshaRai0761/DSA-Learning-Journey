class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode curr = root;
            
            // Reverse word and insert
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                
                curr = curr.children[idx];
            }
        }
        
        return dfs(root, 0);
    }
    
    int dfs(TrieNode node, int depth) {
        
        boolean isLeaf = true;
        
        for (TrieNode child : node.children) {
            if (child != null) {
                isLeaf = false;
                break;
            }
        }
        
        // Leaf node => complete word
        if (isLeaf) {
            return depth + 1;   // +1 for '#'
        }
        
        int ans = 0;
        
        for (TrieNode child : node.children) {
            if (child != null) {
                ans += dfs(child, depth + 1);
            }
        }
        
        return ans;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }
}